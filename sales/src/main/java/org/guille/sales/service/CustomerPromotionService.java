package org.guille.sales.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.mail.internet.MimeUtility;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.guille.sales.persistence.facade.exception.PersistenceException;
import org.guille.sales.model.ICustomerPromotion;
import org.guille.sales.model.implementation.CustomerPromotion;
import org.guille.sales.persistence.facade.ICustomerPromotionPersist;
import org.guille.sales.persistence.hibernate.PersistenceFactory;
import org.guille.sales.util.CustomerPromotionResponse;

@Path("/custprom")
public class CustomerPromotionService extends BaseService {
	private static Logger LOG = LoggerFactory
			.getLogger(CustomerPromotionService.class);

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public CustomerPromotionResponse test(){
		return new CustomerPromotionResponse(1, "Test.");
	}
	
	@POST
	@Path("/addcomment")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public CustomerPromotionResponse addComment(CustomerPromotion cp)
			throws PersistenceException {
		       
		LOG.info("Recibido: {}", cp);
		ICustomerPromotionPersist dao = new PersistenceFactory()
				.getCustomerPromotionPersist();
		//ICustomerPromotion cpl = dao.load(cp.getEmail());
		//if (cpl != null) {
			//return new CustomerPromotionResponse(0,
				//	"Disculpe, no se permite llenar la encuesta más de una vez"); 
	   //}
		try {
		
			cp.setDate(new Date());
			cp.setUserAgent(getServletRequest().getHeader("User-Agent"));
			cp.setClientIP(getServletRequest().getRemoteAddr());
			
			dao.add(cp);
			
			if (cp.getId() > 0) {
				
				return new CustomerPromotionResponse(1, "Gracias! El cupón fue enviado.");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(cp + " - ERROR -->" + e.getMessage(), e);
			return new CustomerPromotionResponse(0, "ERROR");
		}
		return new CustomerPromotionResponse(0, "ERROR");
	}

	

	public void sendHtmlEmail(String host, String port, final String userName,
			final String password, String toAddress, String subject,
			String message, String alias) throws AddressException, MessagingException, UnsupportedEncodingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName, alias));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
		msg.setSentDate(new Date());
		// set plain text message
		msg.setContent(message, "text/html; charset=utf-8");

		// sends the e-mail
		Transport.send(msg);

	}
 
}




