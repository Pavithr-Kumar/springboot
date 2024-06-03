package com.zettamine.spring.rest.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.zettamine.spring.rest.entities.Passenger;
import com.zettamine.spring.rest.entities.Ticket;

@Repository
public class TicketRepository {
	private List<Ticket> tickets = new ArrayList<>();
	private Integer generateRandomPnr() {
		return new Random().nextInt(10000, 99999);
	}
	
	private Float generateRandomPrice() {
		return new Random().nextFloat(100, 1000);
	}
	
	public Ticket generateTicket(Passenger passenger) {
		Ticket t = new Ticket();
		t.setBookingDate(LocalDate.now());
		t.setBookingStatus((new Random().nextBoolean())?"Confirmed":"Pending");
		t.setPassengerName(passenger.getPassengerName());
		t.setPnr(generateRandomPnr());
		t.setTicketFare(generateRandomPrice());
		tickets.add(t);
		return t;
	}
	
	public List<Ticket> getAlltickets(){
		return tickets;
	}

}
