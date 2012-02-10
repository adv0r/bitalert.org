package org.bitalert.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitalert.db.Search;
import org.bitalert.global.Global;
import org.bitalert.model.User;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class PrintAllUsers extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		  UserService userService = UserServiceFactory.getUserService();

	        String thisURL = request.getRequestURI();
	        if (request.getUserPrincipal() != null) {
	        	  
	    		
	      	  Global.log.info("Printing all users");
	      	  response.setContentType("text/plain");
	      		
	            ArrayList<User> allUserList = Search.searchAllUsers();
	      		
	            for (int i=0; i < allUserList.size();i++)
	            {
	          	  User u =  allUserList.get(i);
	          	  response.getWriter().println(u.toString()+"\n----##---- \n");
	            }

	        } else {
	            response.getWriter().println("<p>Please <a href=\"" +
	                                         userService.createLoginURL(thisURL) +
	                                         "\">sign in</a>.</p>");
	        }
	  
	}
}
