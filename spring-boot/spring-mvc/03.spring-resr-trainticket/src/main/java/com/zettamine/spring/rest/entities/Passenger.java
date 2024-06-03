package com.zettamine.spring.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Passenger {
	private Integer passId;
	private String passengerName;
	private Integer trainNo;
	private String traiNanme;
	private String fromStation;
	private String toSation;

}
