package com.bjit.training.employee.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.training.employee.model.ApiResponse;
import com.bjit.training.employee.model.ClassWrapper;
import com.bjit.training.employee.model.Department;
import com.bjit.training.employee.service.DepartmentService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/departments")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<Department> departments = departmentService.findAll();
		if (departments != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("departments", departments))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Department List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		Department department = departmentService.findOne(id);
		if (department != null) {
            return new ApiResponse(ClassWrapper.getWrapper("department", department))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Department not found!");
        }
	}
}
