package com.zettamine.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ContactSupportFallBack {
	@GetMapping("/contactsupport")
	public Mono<String> contactSupport(){
		return Mono.just("Accounts server is currently down, please try again later");
	}

}
