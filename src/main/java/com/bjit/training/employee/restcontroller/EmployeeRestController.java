package com.bjit.training.employee.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.training.employee.model.ApiResponse;
import com.bjit.training.employee.model.ClassWrapper;
import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.service.EmployeeService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<Employee> employees = employeeService.findAll();
		if (employees != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("employees", employees))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Employee List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		Employee employee = employeeService.findOne(id);
		if (employee != null) {
            return new ApiResponse(ClassWrapper.getWrapper("employee", employee))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Employee not found!");
        }
	}
	
	@PostMapping
	public void save(@RequestBody Employee e) {
		System.out.println(e.getJobtype().getId());
		employeeService.save(e);
	}
}
