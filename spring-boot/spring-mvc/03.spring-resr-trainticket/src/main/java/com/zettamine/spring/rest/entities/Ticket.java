package com.zettamine.spring.rest.entities;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@XmlRootElement
public class Ticket {
	private Integer pnr;
	private String passengerName;
	private String bookingStatus;
	private LocalDate bookingDate;
	private Float ticketFare;

}
