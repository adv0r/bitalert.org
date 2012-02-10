package org.bitalert.cron;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitalert.db.Search;
import org.bitalert.global.Global;
import org.bitalert.model.Mail;
import org.bitalert.model.User;
import org.bitalert.util.MailSender;

@SuppressWarnings("serial")
public class SendMail extends HttpServlet {
		
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
			
			ArrayList<User> userList = Search.searchAllUsers();
						
			for (int i=0; i< userList.size() ; i ++ )
			{
				User u = userList.get(i);
				
				if (u.isOverThreshold())
				{
					if(u.isLowSent())
					{				
					    u.setLowSent(false);
						Global.ofy.put(u);
					}
					    
					if(!u.isHighSent()){			
						String subject = "BitAlert: 1 BTC = "+Global.LastTicker.getLast()+"$";
						String body = getBodyMail("high", u)					;
						Mail m = new Mail(Global.EMAIL_SENDER_ADDRESS, Global.EMAIL_SENDER_TITLE, u.getEmailAddress(), subject, body);
						MailSender ms = new MailSender(m);
						ms.run();
						u.setHighSent(true);
						Global.ofy.put(u);
					}
					
					
				}
				
				else if (u.isUnderThreshold()){
					if(u.isHighSent()){
					    u.setHighSent(false);
						Global.ofy.put(u);
					}
					if(!u.isLowSent())
					{
						String subject = "BitAlert: 1 BTC = "+Global.LastTicker.getLast()+"$";
						String body = getBodyMail("low",u);	
						Mail m = new Mail(Global.EMAIL_SENDER_ADDRESS, Global.EMAIL_SENDER_TITLE, u.getEmailAddress(), subject, body);
						MailSender ms = new MailSender(m);
						ms.run();
					    u.setLowSent(true);	
						Global.ofy.put(u);
				   }
				}
				
				else { //Inside the range
					boolean changed = false;
					if(u.isHighSent())
					{
					    u.setHighSent(false);
					    changed = true;
					}
					
					if(u.isLowSent())
					{
					    u.setLowSent(false);
					    changed = true;
					}
					
					if (changed)
						Global.ofy.put(u);			
				}
			}
			
		}
		
		private static String getBodyMail(String type,User u)
		{
			String toReturn ="";
			
			if(type.equals("high"))
			{
			toReturn+= "Alert, the price of 1 BitCoin has increased over the threshold ("+u.getHighThreshold()+") you set!\n"+
			"Now 1 BTC = "+Global.LastTicker.getLast()+"$\n"+
			"_________________ Last Trade from MtGox__\n"+	
			Global.LastTicker.toString()+"\n"+
			"_________________________________________\n"+
			"To modify your thresholds create a new one at http://www.BitAlert.org \n"+
			"Follow us on Twitter, Facebook, and if you'd like to help us, send us some bitcoin\n";	
				
			}
			else {
				toReturn+="Alert, the price of 1 BitCoin has decreased under the threshold ("+u.getLowThreshold()+") you set!\n"+
				"Now 1 BTC = "+Global.LastTicker.getLast()+"$\n"+
				"_____________________________________________\n"+	
				"_________________ Last Trade from MtGox__\n"+	
				Global.LastTicker.toString()+"\n"+
				"_________________________________________\n"+
				"To modify your thresholds create a new one at http://www.BitAlert.org \n"+
				"Follow us on Twitter, Facebook, and if you'd like to help us, send us some bitcoin\n";	
			}
			return toReturn;
		}

}
