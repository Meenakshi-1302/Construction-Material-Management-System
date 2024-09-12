package com.construction.material.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.construction.material.management.system.serviceImpl.MaterialServiceImpl;

import jakarta.annotation.PostConstruct;

@CrossOrigin("*")
@RestController
@RequestMapping("/material")
public class MaterialController {
	
	@Autowired
	private MaterialServiceImpl materialserivceimpl;
	
	@PostMapping
	public String insertMaterial(@RequestParam("materialName") String materialName,@RequestParam("category") String category,@RequestParam("description") String description,@RequestParam("unitOfMeasure") String unitOfMeasure,
			@RequestParam("unitPrice") double unitPrice,@RequestParam("dateOfLastPurchase") LocalDate dateOfPurchase,@RequestParam("expirationDate") LocalDate expirationDate,@RequestParam("picture") byte[] picture,@RequestParam("inventory")Long inventory);

}
