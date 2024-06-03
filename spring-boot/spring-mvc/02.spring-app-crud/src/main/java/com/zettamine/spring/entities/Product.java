package com.zettamine.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer productId;
	private String productName;
	private Float productPrice;

}
