package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

	public Employee findOne(Integer id) {
		return employeeRepository.findOne(id);
	}

	public void save(Employee e) {
		employeeRepository.save(e);
	}
}
