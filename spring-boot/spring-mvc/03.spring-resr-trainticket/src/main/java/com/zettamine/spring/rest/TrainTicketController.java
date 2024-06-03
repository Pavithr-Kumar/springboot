package com.zettamine.spring.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.spring.rest.entities.Passenger;
import com.zettamine.spring.rest.entities.Ticket;
import com.zettamine.spring.rest.repository.PassenegerRepository;
import com.zettamine.spring.rest.repository.TicketRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ticket-booking")
@Tag(name = "Ticket Controller", description = "book tickets here")
public class TrainTicketController {
	private PassenegerRepository passService;
	private TicketRepository ticketService;
	

	
	public TrainTicketController(PassenegerRepository passService, TicketRepository ticketService) {
		super();
		this.passService = passService;
		this.ticketService = ticketService;
	}


	@Tag(name="Create ticket",description = "this method is used to create ticket")
	@PostMapping(path = "/book-new", produces = {"application/json","application/xml"})
	public ResponseEntity<Ticket> bookTicketForPassenegr(@RequestBody Passenger p){
		passService.addPassenger(p);
	Ticket t=	ticketService.generateTicket(p);
	return new ResponseEntity<Ticket>(t,HttpStatus.OK);
	}
	
	@GetMapping("/get-pass")
	public ResponseEntity<Passenger> getPass() {
		return new ResponseEntity<Passenger>(passService.returnNewPassenger() ,HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-all-tickets", produces = {"application/json","application/xml"})
	public ResponseEntity<List<Ticket>> getAllTickets(){
		return new ResponseEntity<List<Ticket>>(ticketService.getAlltickets() ,HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-all-pass", produces = {"application/json","application/xml"})
	public ResponseEntity<List<Passenger>> getAllPass(){
		return new ResponseEntity<List<Passenger>>(passService.getAllPass() ,HttpStatus.OK);
	}
	
    @GetMapping("/pass")
	public ResponseEntity<List<Passenger>> findUserById(@RequestParam Integer id){
		return new ResponseEntity<List<Passenger>>(passService.getPassengerById(id),HttpStatus.OK);
	}
}
