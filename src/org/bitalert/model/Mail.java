package org.bitalert.model;

public class Mail {
	
	private String from;
	private String from_name;
	private String to;
	private String subject;
	private String body;
	
	public Mail(String from,String from_name, String to, String subject, String body) {
		super();
		this.from = from;
		this.from_name = from_name;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getFrom_name() {
		return from_name;
	}
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}


}
