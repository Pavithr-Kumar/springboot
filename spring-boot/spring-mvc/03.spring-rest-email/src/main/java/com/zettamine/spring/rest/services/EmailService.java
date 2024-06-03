package com.zettamine.spring.rest.services;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.zettamine.spring.rest.models.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	private JavaMailSender mailSender;
	private TemplateEngine engine;

	public EmailService(JavaMailSender mailSender,TemplateEngine engine) {
		super();
		this.mailSender = mailSender;
		this.engine = engine;
	}

	public boolean sendEmail(Email email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setSubject(email.getSubject());
		msg.setTo(email.getToAddress());
		msg.setText(email.getMsgBody());
		try {
			mailSender.send(msg);
			return true;
		}catch(Exception e) {
			System.err.println(e);
			
		}
		return false;
	}
	
	public boolean sendMimeMessage(Email email) {
		Context context =new Context();
		context.setVariable("fname", "Punya");
		context.setVariable("lname", "Koti");
		String contents = 	engine.process("email", context);
		String fromAdd = "eren <pulicherlapunyakotireddy@gmail.com>";
		MimeMessage mimeMsg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg,true);
			helper.setSubject(email.getSubject());
			helper.setTo(email.getToAddress());
			helper.setText(contents,true);
			helper.setFrom(fromAdd);
			mailSender.send(mimeMsg);
            return true;			
		} catch (MessagingException e) {
			return false;
		}
		
	} 

}
