package com.zettamine.spring.mi.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "mtrl_insp_char")
@ToString(exclude = {"material"})
public class MaterialInspectionCharacteristics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer characteristicId;
	private String characteristicDescription;
	private Float characteristicTolUpperLimit;
	private Float characteristicTolLowerLimit;
	private String characteristicUOM;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name =  "material_id")
	private Material material;
	@OneToMany(mappedBy = "ispCharacteristics",cascade = CascadeType.ALL)
	private List<InspectionActuals> ispActuals;

}
