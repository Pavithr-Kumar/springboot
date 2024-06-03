package com.zettamine.spring.ems.dao;

import java.util.List;

import com.zettamine.spring.ems.dto.Employee;

public interface EmployeeDao {
	Integer insertEmployee(Employee emp);
	Integer updateEmployee(Employee emp);
	Integer deleteEMployee(Integer id);
	Employee findById(Integer id);
	List<Employee> getAll();

}
