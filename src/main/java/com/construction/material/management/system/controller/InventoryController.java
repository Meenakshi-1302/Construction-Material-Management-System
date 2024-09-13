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

import com.construction.material.management.system.model.Inventory;
import com.construction.material.management.system.serviceImpl.InventoryServiceImpl;



@CrossOrigin("*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImpl inventoryserviceimpl;
	
	@PostMapping
	public String insertInventory(@RequestBody Inventory inventory) {
		
		String msg="";
		try {
			inventoryserviceimpl.addInventory(inventory);
			msg="Success";
		}
		catch(Exception e) {
			msg="failure";
		}
		return msg;
	}
	
	@GetMapping("{inventoryId}")
	public Inventory getInventoryById(@PathVariable("inventoryId") Long id) {
		return inventoryserviceimpl.findInventoryById(id);
	}
	
	@GetMapping("/all")
	public List<Inventory> getInventories(){
		return inventoryserviceimpl.findAllInventories();
	}
	@DeleteMapping("{inventoryId}")
	public String deleteInventory(@PathVariable("inventoryId") Long id) {
		String msg="";
		try {
			inventoryserviceimpl.deleteInventory(id);
			msg="deleted";
		} catch(Exception e) {
			msg="Not deleted";
		}
		return msg;
	}

}
