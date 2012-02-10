package org.bitalert.db;

import org.bitalert.cron.UpdateBTCprice;
import org.bitalert.global.Global;
import org.bitalert.model.ScheduledTrade;
import org.bitalert.model.Ticker;
import org.bitalert.model.User;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class RegisterObject {
	
	public static void register() {
		if(!Global.objectRegistered){
		ObjectifyService.register(Ticker.class);
		ObjectifyService.register(User.class);	
		ObjectifyService.register(ScheduledTrade.class);	
		
		/* __________________________________________________ */
		//deleteAllDatabase();  // DANGER !!!!!! COMMENT THIS LINE !!!
		/* -------------------------------------------------- */
		
		//registerTrades();
		UpdateBTCprice.update();

		Global.objectRegistered = true;
		}
	}

	private static void registerTrades() {
		ScheduledTrade s1 = new ScheduledTrade(7.08, 32, true,"paternoster.nicolo@gmail.com"); //Sell 7.08 when 1 BTC is more than 21
		ScheduledTrade s2 = new ScheduledTrade (5.45, 27, true,"paternoster.nicolo@gmail.com"); //Sell 5.45 when 1 BTC is more than 21
		ScheduledTrade s3 = new ScheduledTrade(0.1, 20, true,"paternoster.nicolo@gmail.com"); //PROVA 
		
		Global.ofy.put(s1);
		Global.ofy.put(s2);
		Global.ofy.put(s3);
	}
	
	
	/*Danger, never use*/
	private static void deleteAllDatabase() 
	{
		Iterable<Key<User>> allKeysUser = Global.ofy.query(User.class).fetchKeys();
		Iterable<Key<Ticker>> allKeysTicker = Global.ofy.query(Ticker.class).fetchKeys();
		Iterable<Key<ScheduledTrade>> allKeysScheduledTrade = Global.ofy.query(ScheduledTrade.class).fetchKeys();
		Global.ofy.delete(allKeysUser);
		Global.ofy.delete(allKeysTicker);
		Global.ofy.delete(allKeysScheduledTrade);

	}
	
}
