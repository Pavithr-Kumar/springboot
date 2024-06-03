package com.zettamine.spring.mi.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "plant_dtls")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "inspectionLots")
public class Plant {
	@Id
	private String plantId;
	private String plantName;
	private String plantState;
	private String plantCity;
	private String plantActiveStatus;
	@OneToMany(mappedBy = "plant",cascade = CascadeType.ALL)
	private List<InspectionLot> inspectionLots = new ArrayList<>();

}
