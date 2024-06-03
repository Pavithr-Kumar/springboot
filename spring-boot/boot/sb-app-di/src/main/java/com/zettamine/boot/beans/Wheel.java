package com.zettamine.boot.beans;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

	public Wheel() {
		LoggerFactory.getLogger(Wheel.class).info("### Wheel Bean");
	}
	

}
