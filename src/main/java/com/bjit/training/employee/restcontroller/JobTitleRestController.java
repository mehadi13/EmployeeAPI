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
import com.bjit.training.employee.model.JobTitle;
import com.bjit.training.employee.service.JobTitleService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/jobtitles")
public class JobTitleRestController {
	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<JobTitle> jobtitles = jobTitleService.findAll();
		if (jobtitles != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("jobtitles", jobtitles))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Job Title List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		JobTitle jobTitle = jobTitleService.findOne(id);
		if (jobTitle != null) {
            return new ApiResponse(ClassWrapper.getWrapper("jobtitle", jobTitle))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Job Title not found!");
        }
	}
	
	@PostMapping
	public void s(@RequestBody JobTitle jobTitle){
		System.out.println(jobTitle.getName());
	}
}
