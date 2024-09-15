package com.construction.material.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.material.management.system.model.FormRequest;
import com.construction.material.management.system.serviceImpl.FormRequestServiceImpl;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class FormRequestController {
	
	@Autowired
	private FormRequestServiceImpl formrequestserviceimpl;
	
	@PostMapping
	public String addRequest(@RequestBody FormRequest formrequest) {
		String msg="";
		try {
			formrequestserviceimpl.addFormRequest(formrequest);
			msg="added";
			
		}catch(Exception e) {
			msg="not added";
		}
		return msg;
	}
	@GetMapping("/all")
	public List<FormRequest> getFormRequests(){
		return formrequestserviceimpl.findAllFormRequests();
	}
	
	@GetMapping("{requestId}")
	public FormRequest getFormRequestById(@PathVariable("requestId") Long id) {
		return formrequestserviceimpl.findFormRequestById(id);
	}
	@DeleteMapping
	public String deleteFormRequest(@PathVariable("requestId") Long id) {
		String msg="";
		try {
			formrequestserviceimpl.deleteFormRequest(id);
			msg="deleted";
		}catch(Exception e) {
			msg="not deleted";
		}
		return msg;
	}

}
