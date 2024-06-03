package com.zettamine.spring.mi.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="isp_lot")

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class InspectionLot {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "isp_seq_gen")
	@SequenceGenerator(name = "isp_seq_gen",sequenceName = "isp_seq_gen",allocationSize = 1,initialValue = 4700)
	private Integer inspectionLotId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "material_id")
	private Material material;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plant_id")
	private Plant plant;
	private Date inspCreatedDate;
	private Date inspStartDate;
	private Date inspEndtDate;
	private String inspectionResult;
	private String inspectionRemarks;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy = "ispLot")
	private List<InspectionActuals> ispActuals;
	
	
	
	

}
