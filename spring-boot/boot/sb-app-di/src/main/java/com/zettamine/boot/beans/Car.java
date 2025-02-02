package com.zettamine.boot.beans;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	@Autowired
//	@Qualifier("dieselEngine")
	private Engine engine;
	private Wheel wheel;
	
	//@Autowired
	public Car(@Qualifier("dieselEngine") Engine eng,Wheel wheel){
		//System.out.println("Car Bean Created");
		LoggerFactory.getLogger(PetrolEngine.class).info("\033[32mCar :: Bean Created\033[0m");
		this.engine=eng;
		this.wheel=wheel;
	}
	

	
//	@Autowired
//	@Qualifier("dieselEngine")
//    public void setEngine(Engine engine) {
//		this.engine = engine;
//	}


	public void startJourney() {
    	engine.startEngine();
    }
}
