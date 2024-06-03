package com.zettamine.spring.mi.model;

import com.zettamine.spring.mi.entities.InspectionLot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Actual {
	private InspectionLot ispLot;
	//private String Characteristic;
	private Float upperTol;
	private Float lowerTol;
	private Float actualMax;
	private Float actualMin;
	private String charUom;

}
