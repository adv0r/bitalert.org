package org.bitalert.model;

import javax.persistence.Id;

import org.bitalert.global.Global;

public class User {
	
	@Id private Long id;
	
	private String emailAddress;
	private double currentVal;
	private double highThreshold;
	private double lowThreshold;

	private boolean highSent;
	private boolean lowSent;
	
	public User(){};
	public User(String emailAddress, double currentVal, double highTreshold,
			double lowThreshold) {
		super();
		this.emailAddress = emailAddress;
		this.currentVal = currentVal;
		this.highThreshold = highTreshold;
		this.lowThreshold = lowThreshold;
		this.highSent=false;
		this.lowSent=false;
	}

	public boolean isUnderThreshold()
	{
		if(Global.LastTicker.getLast() < this.lowThreshold)
			return true;
			else return false;
	}
	
	public boolean isOverThreshold()
	{
		if(Global.LastTicker.getLast() > this.highThreshold)
			return true;
			else return false;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public double getCurrentVal() {
		return currentVal;
	}

	public void setCurrentVal(double currentVal) {
		this.currentVal = currentVal;
	}

	public double getHighThreshold() {
		return highThreshold;
	}

	public void setHighThreshold(double highThreshold) {
		this.highThreshold = highThreshold;
	}

	public double getLowThreshold() {
		return lowThreshold;
	}

	public void setLowThreshold(double lowThreshold) {
		this.lowThreshold = lowThreshold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isHighSent() {
		return highSent;
	}
	public void setHighSent(boolean highSent) {
		this.highSent = highSent;
	}
	public boolean isLowSent() {
		return lowSent;
	}
	public void setLowSent(boolean lowSent) {
		this.lowSent = lowSent;
	}

	public String toString(){
		String toReturn="";
		
		toReturn += "id = " + getId() +"\n"+
		"email = " + getEmailAddress() +"\n"+
		"currentVal = " + getCurrentVal()+"\n"+
		"high = " + getHighThreshold() +"\n"+
		"low= " + getLowThreshold()+"\n"+
		"isLowSent = "+isLowSent()+"\n"+
		"isHighSent = "+isHighSent();
		
		return toReturn;
	}
}
