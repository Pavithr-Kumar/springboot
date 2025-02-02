package com.zettamine.boot.beans;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine {
	
	public PetrolEngine() {
		LoggerFactory.getLogger(PetrolEngine.class).info("\033[32mPetrol Engine :: Bean Created\033[0m");
		//System.out.println("Petrol Engine :: Bean Created");
	}

	@Override
	public void startEngine() {
		LoggerFactory.getLogger(PetrolEngine.class).info("\033[32mPetrol Engine :: Started\033[0m");
		//System.out.println("Petrol Engine :: Started");

	}

}
