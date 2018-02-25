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
import com.bjit.training.employee.model.Nationality;
import com.bjit.training.employee.service.NationalityService;
import com.bjit.training.employee.util.ReturnCode;

@RestController
@CrossOrigin
@RequestMapping("/nationalities")
public class NationalityRestController {
	@Autowired
	private NationalityService nationalityService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> findAll(){
		List<Nationality> nationalities = nationalityService.findAll();
		if (nationalities != null) {
		    return new ApiResponse(ClassWrapper.getWrapper("nationalities", nationalities))
		    		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
	        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Nationality List not found!");
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse>  getOne(@PathVariable Integer id){
		Nationality nationality = nationalityService.findOne(id);
		if (nationality != null) {
            return new ApiResponse(ClassWrapper.getWrapper("nationality", nationality))
            		.send(HttpStatus.OK,ReturnCode.SUCCESS,"Successful");
        } else {
            return new ApiResponse().send(HttpStatus.NOT_FOUND, "Nationality not found!");
        }
	}
}
