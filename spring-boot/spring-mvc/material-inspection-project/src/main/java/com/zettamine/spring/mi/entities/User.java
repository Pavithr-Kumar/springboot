package com.zettamine.spring.mi.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_dtls")
@ToString(exclude = "inspectionLots")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	//@Pattern(regexp = "^[A-Za-z]*$", message = "Username must contain only alphabetic characters")
	private String userName;
	private String userPassword;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<InspectionLot> inspectionLots = new ArrayList<>();

}
