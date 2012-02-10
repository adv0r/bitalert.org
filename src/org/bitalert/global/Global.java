package org.bitalert.global;

import java.util.logging.Logger;

import org.bitalert.model.Ticker;
import org.bitalert.servlet.TickerServlet;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class Global {
			
	/* Logger */
    public static final Logger log = Logger.getLogger(TickerServlet.class.getName());

	
	/* Email */
	public static final String EMAIL_SENDER_ADDRESS = "no-reply@bitcoinalert.appspotmail.com";
	public static final String EMAIL_SENDER_TITLE = "BitAlert.org";
	
	/* Utils */	
	
	public static final String TICKER_EQUAL = "sameValue";
	public static final String TICKER_GRATER = "grater";
	public static final String TICKER_WORSE = "worse";
	
	public static double LastPrice = 0 ;
	public static Ticker LastTicker = new Ticker(0,0,0,0,0,0, "");
	public static String ImproveString = TICKER_EQUAL;

	/* Object registered */
	
	public static boolean objectRegistered = false;
	

	/* MtGox */
	public static final String MTGOX_TICKER_STRING = "http://mtgox.com/code/data/ticker.php";
	
	/* DB */
	public static Objectify ofy = ObjectifyService.begin();


}
