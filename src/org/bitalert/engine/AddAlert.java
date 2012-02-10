package org.bitalert.engine;

import java.util.ArrayList;

import org.bitalert.db.Search;
import org.bitalert.global.Global;
import org.bitalert.model.User;

public class AddAlert {
	
	public static void add(String email,String lowThreshold,String highThreshold)
	{
		double currentBitChange = Global.LastTicker.getLast();
		Global.log.info(email+" "+lowThreshold+" "+highThreshold);
		//TODO VALIDATE DATA!!!!!!!!!
		
		//Check if exist already the email address in the database
		if (Search.userExists(email))
		{
			Global.log.info("User "+email+" exists!");
			ArrayList<User> listToDelete = Search.searchUser(email);
			for (int i=1; i< listToDelete.size();i++)
			{
				User t = listToDelete.get(i);
				Global.ofy.delete(t);
			}
		}
		User u = new User(email,currentBitChange,Double.parseDouble(highThreshold),Double.parseDouble(lowThreshold));
		Global.ofy.put(u);
	}
}
