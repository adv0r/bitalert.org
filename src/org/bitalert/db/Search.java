package org.bitalert.db;	
import java.util.ArrayList;

import org.bitalert.global.Global;
import org.bitalert.model.ScheduledTrade;
import org.bitalert.model.User;

import com.googlecode.objectify.Query;


public class Search {
	

	public static ArrayList<User> searchUser(String email)
	{	     
		ArrayList<User> result = new ArrayList<User>();
		Query<User> q = Global.ofy.query(User.class).filter("emailAddress", email);
		for (User user: q) {
			result.add(user);	
			}		
	    return result;
	}
	
	public static ArrayList<User> searchAllUsers()
	{
		Query<User> q = Global.ofy.query(User.class);    
	    ArrayList<User> users = new ArrayList<User>();
	    
	    //Loop the query results and add to the array
	    for (User fetched : q) {
	      users.add(fetched);
	    }
	    
	    return users;
	}
	
	public static ArrayList<User> searchUser(long id)
	{
		return null;
	}
	
	public static boolean userExists(String email)
	{	
		boolean toReturn=false;		
		Query<User> q = Global.ofy.query(User.class).filter("emailAddress", email);
		for (User fetched : q) {
			      return true;
			 }
		return toReturn;
	}
	
	public static ArrayList<ScheduledTrade> searchAllScheduledTrade()
	{
		Query<ScheduledTrade> q = Global.ofy.query(ScheduledTrade.class);    
	    ArrayList<ScheduledTrade> scheduled = new ArrayList<ScheduledTrade>();
	    
	    //Loop the query results and add to the array
	    for (ScheduledTrade fetched : q) {
	    	scheduled.add(fetched);
	    }
	    
	    return scheduled;
	}
	
	
}
