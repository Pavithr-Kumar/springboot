package com.zettamine.spring.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Email {
	private String toAddress;
	private String subject;
	private String msgBody;

}
