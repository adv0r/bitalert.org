package org.bitalert.cron;
import javax.servlet.*;
import javax.servlet.http.*;

import org.bitalert.db.Search;
import org.bitalert.global.Global;
import org.bitalert.model.Mail;
import org.bitalert.model.ScheduledTrade;
import org.bitalert.util.MailSender;

import java.io.*;
import java.net.*;
import java.util.*;

/* 
https://mtgox.com/code/sellBTC.php?name=advanced&pass=ciriciao&amount=12.52#&price=#
  */

@SuppressWarnings("serial")
public class AutoTrade extends HttpServlet {
    private final String CONTENT_TYPE = "text/html";
    private final String USERNAME = "advanced";
    private final String PASSWORD = "ciriciao";
    private final String SELL_URL = "https://mtgox.com/code/sellBTC.php";
    
    private  ArrayList<ScheduledTrade> tradeList = new ArrayList<ScheduledTrade>();
    private  ArrayList<ScheduledTrade> tradeToPerform = new ArrayList<ScheduledTrade>();
    
	

    public void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, 
		      IOException {
	response.setContentType(CONTENT_TYPE);

	getTrades();
    selectTradesToPerform();
    
    for(int i=0; i< tradeToPerform.size(); i++)
     {
    	ScheduledTrade st = tradeToPerform.get(i);
    	if(!st.isPerformed())
    		performTrade(st,response);
     }
    }

	private void performTrade(ScheduledTrade st,HttpServletResponse response) {
		URL		 url;
		URLConnection    urlConn;
		DataOutputStream cgiInput;
		try {
		url = new URL(SELL_URL);
		urlConn = url.openConnection();

		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		urlConn.setUseCaches(false);
		urlConn.setRequestProperty("Content-Type", 
					   "application/x-www-form-urlencoded");

	
			cgiInput = new DataOutputStream(urlConn.getOutputStream());
			@SuppressWarnings("deprecation")
			String content = "name=" + URLEncoder.encode(USERNAME) 
					 + "&pass="  + URLEncoder.encode(PASSWORD)
					 + "&amount="+URLEncoder.encode(Double.toString(st.getQuota()))
					 + "&price="+URLEncoder.encode(Double.toString(Global.LastTicker.getSell()));

			cgiInput.writeBytes(content);
			cgiInput.flush();
			cgiInput.close();
			
			//Send an email to me
			MailSender mail = new MailSender(new Mail("paternoster.nicolo@gmail.com","Bit Alert AUTO TRADE ALERT",st.getEmail(),
					"Trade submitted!","Sold : "+st.getQuota()+" because price was "+st.getThreshold()));
			mail.run();
			
			//Update the db
			st.setPerformed(true);
			Global.ofy.put(st);
			
			//print output
			BufferedReader cgiOutput = 
			    new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			PrintWriter    servletOutput = response.getWriter();        
			servletOutput.print("<html><body><h1>This is the Source Servlet</h1><p />");
			String line = null;
			while (null != (line = cgiOutput.readLine())){
			    servletOutput.println(line);
			}
			cgiOutput.close();
			servletOutput.print("</body></html>");
			servletOutput.close();
		} catch (Exception e) {
			Global.log.warning("Error in posting data");
		}

		

	}

	private void selectTradesToPerform() {
		for (int i=0 ; i< tradeList.size(); i++)
		{
			ScheduledTrade st = tradeList.get(i);
			if(st.isSellWhenIsHigher())
			{
				if(Global.LastTicker.getLast() > st.getThreshold())
					tradeToPerform.add(st);
			}
			
			else //sell when is lower
			{
				if(Global.LastTicker.getLast() < st.getThreshold())
					tradeToPerform.add(st);			
			}
			
		}		
	}

	private void getTrades() {
		tradeList = Search.searchAllScheduledTrade();
	}


}
