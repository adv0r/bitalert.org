package org.bitalert.model;

import javax.persistence.Id;

public class ScheduledTrade {
	
	@Id private Long id;

	private double quota;
	private double threshold;
	private boolean sellWhenIsHigher;
	private String email;
	public boolean isPerformed() {
		return performed;
	}
	public void setPerformed(boolean performed) {
		this.performed = performed;
	}
	private boolean performed;
	
	public ScheduledTrade(){}
	public ScheduledTrade(double quota, double threshold,
			boolean sellWhenIsHigher,String email) {
		super();
		this.quota = quota;
		this.threshold = threshold;
		this.sellWhenIsHigher = sellWhenIsHigher;
		this.email = email;
		this.performed = false;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getQuota() {
		return quota;
	}
	public void setQuota(double quota) {
		this.quota = quota;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public boolean isSellWhenIsHigher() {
		return sellWhenIsHigher;
	}
	public void setSellWhenIsHigher(boolean sellWhenIsHigher) {
		this.sellWhenIsHigher = sellWhenIsHigher;
	}


}
