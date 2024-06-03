package com.zettamine.spring.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.spring.rest.models.Email;
import com.zettamine.spring.rest.services.EmailService;

@RestController
@RequestMapping("/zetta")

public class MailController {
	private EmailService emailService;
	
	
	public MailController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}


	@PostMapping("/send-mail")

	public ResponseEntity<String> sendEmail(@RequestBody Email email) {
		
		// boolean b= emailService.sendEmail(email);
		 boolean b= emailService.sendMimeMessage(email);
		 if(b) return new ResponseEntity<>("Mail sent successfully",HttpStatus.OK);
		 else return new ResponseEntity<>("Failed to send Email",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
