package com.zettamine.spring.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Train {
	private Integer trainNo;
	private String traiNanme;
	private String fromStation;
	private String toSation;

}
