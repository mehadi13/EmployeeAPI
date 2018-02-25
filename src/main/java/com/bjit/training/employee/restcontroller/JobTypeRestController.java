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
import com.bjit.training.employee.model.JobType;
import com.bjit.training.employee.service.JobTypeService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/jobtypes")
public class JobTypeRestController {
	@Autowired
	private JobTypeService jobTypeService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<JobType> jobtypes = jobTypeService.findAll();
		if (jobtypes != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("jobtypes", jobtypes))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Job Type List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		JobType jobType = jobTypeService.findOne(id);
		if (jobType != null) {
            return new ApiResponse(ClassWrapper.getWrapper("jobtype", jobType))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "JobType not found!");
        }
	}
}
