package org.bitalert.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bitalert.global.Global;
import org.bitalert.model.Mail;


public class MailSender implements Runnable {
	private Mail mail;
	
	public MailSender(Mail mail){
		this.mail=mail;	
	}
	
	
	@Override
	public void run() {		
		Global.log.info("Sending email "+mail.toString());
		Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);
	        try {
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(mail.getFrom(), mail.getFrom_name()));
	            msg.addRecipient(Message.RecipientType.TO,
	                             new InternetAddress(mail.getTo(), mail.getTo()));
	            msg.setSubject(mail.getSubject());
	            msg.setText(mail.getBody());
	            Transport.send(msg);

	        } catch (Exception e) {
	        	e.printStackTrace();
	        } 	
	}
		

public Mail getMail() {
	return mail;
}


public void setMail(Mail mail) {
	this.mail = mail;
}

}
