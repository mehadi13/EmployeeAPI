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
import com.bjit.training.employee.model.Gender;
import com.bjit.training.employee.service.GenderService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/genders")
public class GenderRestController {
	@Autowired
	private GenderService genderService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<Gender> genders = genderService.findAll();
		if (genders != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("genders", genders))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Gender List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		Gender gender = genderService.findOne(id);
		if (gender != null) {
            return new ApiResponse(ClassWrapper.getWrapper("gender", gender))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Gender not found!");
        }
	}
}
