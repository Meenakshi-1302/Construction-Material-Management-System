package com.construction.material.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.construction.material.management.system.model.Inventory;
import com.construction.material.management.system.model.Material;
import com.construction.material.management.system.serviceImpl.InventoryServiceImpl;
import com.construction.material.management.system.serviceImpl.MaterialServiceImpl;



@CrossOrigin("*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImpl inventoryserviceimpl;
	
	@Autowired
	private MaterialServiceImpl materialserviceimpl;
	
	 @PostMapping("/add")
	    public Inventory addInventory(
	            @RequestParam("reorderLevel") int reorderLevel,
	            @RequestParam("status") String status,
	            @RequestParam("batchNumberOrSerialNumber") String batchNumberOrSerialNumber,
	            @RequestParam("materialId") int materialId) {	   
//	         Create and set Inventory object
	        Inventory inventory = new Inventory();
	        inventory.setReorderLevel(reorderLevel);
	        inventory.setStatus(status);
	        inventory.setBatchNumberOrSerialNumber(batchNumberOrSerialNumber);
	        System.out.println(reorderLevel);
	        // Fetch material by ID
	        Material material = materialserviceimpl.findMaterialById(materialId);
	        
	        inventory.setMaterial(material);

	        // Save inventory
	         inventoryserviceimpl.addInventory(inventory);
		return null;
//		 int id = inventory.getMaterial().getMaterialId();
//		 Material material = materialserviceimpl.findMaterialById(id);
//		 inventory.setMaterial(material);
//		 inventoryserviceimpl.addInventory(inventory);
//		 return inventory;

	        
	    }
	 
	 @PutMapping
	 public String updateInventory(@RequestParam("reorderLevel") int reorderLevel,
	            @RequestParam("status") String status,
	            @RequestParam("batchNumberOrSerialNumber") String batchNumberOrSerialNumber,
	            @RequestParam("materialId") int materialId) {
		 String msg="";
		 Inventory inventory = new Inventory();
			try {
				inventoryserviceimpl.updateInventory(inventory);
				msg="updated";
			}catch(Exception e) {
				msg="not updated";
				
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
