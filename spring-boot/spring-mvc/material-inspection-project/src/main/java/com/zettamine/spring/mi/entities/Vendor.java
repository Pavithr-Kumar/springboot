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

@Entity
@Table(name = "vendor_dtls")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude = "inspectionLots")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vendorId;
	private String vendorName;
	private String vendorEmail;
	private String vendorState;
	private String vendorCity;
	private String vendorActiveStatus;
	@OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
	private List<InspectionLot> inspectionLots = new ArrayList<>();

}
