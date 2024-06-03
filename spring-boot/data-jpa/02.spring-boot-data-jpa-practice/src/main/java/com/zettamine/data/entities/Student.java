package com.zettamine.data.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue
	private Integer Id;
	@Column(unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Course> course;

//	public Student(String name, Course course) {
//		super();
//		this.name = name;
//		this.course = course;
//	}
	
	

}
