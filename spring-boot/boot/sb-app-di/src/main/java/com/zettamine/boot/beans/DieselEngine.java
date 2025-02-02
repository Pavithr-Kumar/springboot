package com.zettamine.boot.beans;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DieselEngine implements Engine {
	public DieselEngine() {
		//System.out.println("Diesel Engine :: Bean Created");
		LoggerFactory.getLogger(DieselEngine.class).info("\033[32mDiesel Engine :: Bean Created");
	}

	@Override
	public void startEngine() {
		//System.out.println("Diesel Engine :: Started");
		LoggerFactory.getLogger(DieselEngine.class).info("\033[32mDiesel Engine :: Started");

	}

}
