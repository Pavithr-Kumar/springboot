package com.zettamine.spring.rest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zettamine.spring.rest.entities.Passenger;

@Repository
public class PassenegerRepository {
	List<Passenger> passengers = new ArrayList<>();
	
	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
		
	}
	
	public List<Passenger> getPassengerById(Integer id) {
		return passengers.stream().filter(pass->pass.getPassId()==id).collect(Collectors.toList());
	}
	
	public Passenger returnNewPassenger() {
		Passenger p = new Passenger();
		p.setFromStation("Vizag");
		p.setPassengerName("Ravi");
		p.setPassId(121);
		p.setToSation("Hyderabad");
		p.setTraiNanme("Venkatadri Express");
		p.setTrainNo(537873762);
		passengers.add(p);
		return p;
	}
	public List<Passenger> getAllPass() {
		return passengers;
	}

}
