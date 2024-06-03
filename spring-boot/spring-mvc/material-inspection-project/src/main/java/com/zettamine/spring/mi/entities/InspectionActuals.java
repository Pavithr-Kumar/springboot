package com.zettamine.spring.mi.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="isp_act")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"ispLot","ispCharacteristics"})
public class InspectionActuals {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "act_seq_gen")
	@SequenceGenerator(allocationSize = 1,name = "act_seq_gen",sequenceName = "act_seq_gen",initialValue = 200)
	private Integer actualsId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lot_id")
	private InspectionLot ispLot;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ch_id")
	private MaterialInspectionCharacteristics ispCharacteristics;
	private	Float actualMaxMeasure;
	private	Float actualMinMeasure;

}
