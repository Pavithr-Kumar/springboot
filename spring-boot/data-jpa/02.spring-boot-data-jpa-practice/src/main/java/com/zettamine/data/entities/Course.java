package com.zettamine.data.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue
	private Integer cId;
	@Column(unique = true)
    private String cDesc;
    
    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
    		joinColumns = { @JoinColumn(name = "cId")},
    		inverseJoinColumns = { @JoinColumn(name = "Id")}
    		)
    private List<Student> student;
    
//    private Student student;

}
