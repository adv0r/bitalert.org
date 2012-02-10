package org.bitalert.model;

import java.util.Calendar;

import javax.persistence.Id;

public class Ticker {
	
	
	@Id private Long id;

	private double high;
	private double low;
	private double vol;
	private double buy;
	private double sell;
	private double last;
	private String ticker;
	
	private long time;  //Date of the ticker creation in millis
	
	public Ticker(){}
	
	public Ticker(double high, double low, double vol, double buy, double sell,
			double last, String ticker) {
		super();
		this.high = high;
		this.low = low;
		this.vol = vol;
		this.buy = buy;
		this.sell = sell;
		this.last = last;
		this.ticker = ticker;
		Calendar now = Calendar.getInstance();
		time = now.getTimeInMillis();
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVol() {
		return vol;
	}

	public void setVol(double vol) {
		this.vol = vol;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public long getTime() {
		return time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String toString() {
		String toReturn="";
		toReturn +="Last price = "+getLast()+" \n"+
		"Lower = "+getLow()+" \n"+
		"Higher = "+getHigh()+" \n"+
		"Volume = "+getVol()+" \n"+
		"Sell = "+getSell()+" \n"+
		"Buy = "+getBuy() +"\n"+
		"Timestamp = "+getTime();
		return toReturn;
	}


	

}
