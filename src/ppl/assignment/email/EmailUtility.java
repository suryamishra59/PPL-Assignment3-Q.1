package ppl.assignment.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

	public static void sendEmail(String host, String port, final String sender, final String password, String subject,
			String name, String body, String email, String phone) throws AddressException, MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		StringBuilder bodyText = new StringBuilder();
		bodyText.append("From: " + email + ". <br> Phone: " + phone
				+ "<br><br><div style='background: #2d2d2d;color: #fff; border-radius: 10px; padding:1.2em; font-size: 1.2em;'>")
				.append(body).append("</div>");
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("suryamishra59@gmail.com", name));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("suryamishra59@gmail.com"));
		message.setSubject(subject);
		message.setContent(bodyText.toString(), "text/html; charset=utf-8");
		Transport.send(message);

	}
}
