package com.zettamine.spring.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Employee {
	private Integer empId;
	private String empName;
	private String depName;
	private Float empSal;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public Employee(Integer empId, String empName, String depName, Float empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.depName = depName;
		this.empSal = empSal;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Float empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", depName=" + depName + ", empSal=" + empSal
				+ "]";
	}
	
	

}
