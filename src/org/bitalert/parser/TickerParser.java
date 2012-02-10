package org.bitalert.parser;

import org.bitalert.global.Global;
import org.bitalert.model.Ticker;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TickerParser {
	/* Parse the JSON String of the format
	 * {"ticker":{"high":31.5,"low":22.8897,"vol":88166,"buy":29.03,"sell":29.04,"last":29.04}}
	 * Creating a new Ticker Object*/
	
	public static Ticker createTicker(String input)
	{
		Ticker toReturn = null;
		double high,low,vol,buy,sell,last;
		String ticker;
		JSONObject json1,json2;
		try {
			json1 = (JSONObject)new JSONParser().parse(input);
			String  str1 = ""+json1.get("ticker");
			json2 = (JSONObject)new JSONParser().parse(str1);
			
			high = Double.parseDouble(""+json2.get("high"));
			low = Double.parseDouble(""+json2.get("low"));
			vol = Double.parseDouble(""+json2.get("vol"));
			buy = Double.parseDouble(""+json2.get("buy"));
			sell = Double.parseDouble(""+json2.get("sell"));
			last = Double.parseDouble(""+json2.get("last"));
			ticker = input;
			toReturn = new Ticker(high, low, vol, buy, sell, last, ticker);

		} catch (Exception e) {
			Global.log.warning("Error while parsing the Ticker");
		}
		return toReturn;
	}
	
	public static String isGrater(Ticker t1,Ticker t2)
	{
		String toReturn = Global.TICKER_EQUAL;
		if(t1.getLast() > t2.getLast() )
			toReturn = Global.TICKER_GRATER;
		else if( t1.getLast()< t2.getLast())
			toReturn = Global.TICKER_WORSE;
		return toReturn;
	}

}
