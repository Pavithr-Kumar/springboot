package com.zettamine.data.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	private String customerName;
	private String customerLocation;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	private Product product;
	public Customer(String customerName, String customerLocation, Product product) {
		super();
		this.customerName = customerName;
		this.customerLocation = customerLocation;
		this.product = product;
	}

}
