package utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import NoiThat.Entity.User;


public class Email {

	// random otp 
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
	
	public boolean sendEmail(User user) {
		
		boolean test = false;
		String toEmail = user.getEmail();
		String fromEmail = "an2572003@gmail.com";
		String password = "dqxnzoprrwnmwnmn";
		
		try {
			
			// your host email smtp server details
			Properties pr = configEmail(new Properties());
			// get session o authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			}); 
			
			// set email message details
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-type", "text/plain; charset=UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			// set email subject
			mess.setSubject("Confirm code");
			
			// set message text
			mess.setText("Your code is: " + user.getCode());
			
			// send the message
			Transport.send(mess);
			
			test = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	
	public Properties configEmail(Properties pr) {
		// your host email smtp server details
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		return pr;
		
	}
	
//	public static void main(String[] args) {
//		Email sm = new Email();
//		User user = new User("test1", "anv2672003@gmail.com", "123452", "toi la test");
//		
//		boolean test = sm.sendEmail(user);		
//		
//		if(test) {
//			System.out.println("Thành công");
//		}else {
//			System.out.println("Lỗi");
//		}
//	}
	
}
