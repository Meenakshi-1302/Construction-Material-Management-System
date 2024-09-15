package com.construction.material.management.system.controller;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.construction.material.management.system.model.Material;
import com.construction.material.management.system.serviceImpl.MaterialServiceImpl;



@CrossOrigin("*")
@RestController
@RequestMapping("/materials")
public class MaterialController {
	
	@Autowired
	private MaterialServiceImpl materialserviceimpl;
	
	@PostMapping
	public Material insertMaterial(@RequestParam("materialName") String materialName,@RequestParam("category") String category,
			@RequestParam("description") String description, @RequestParam("unitOfMeasure") String unitOfMeasure, 
			@RequestParam("unitPrice") double unitPrice,@RequestParam("quantity") int quantity,
			@RequestParam("dateOfLastPurchase") LocalDate dateOfLastPurchase,@RequestParam("expirationDate") LocalDate expirationDate, 
			@RequestParam("picture") MultipartFile picture) {
		try {
			byte[] pictureBytes = picture.getBytes();
			
			
			Material material = new Material();
			material.setMaterialName(materialName);
			material.setCategory(category);
			material.setDescription(description);
			material.setUnitOfMeasure(unitOfMeasure);
			material.setUnitPrice(unitPrice);
			material.setQuantity(quantity);
			material.setDateOfLastPurchase(dateOfLastPurchase);
			material.setExpirationDate(expirationDate);
			material.setPicture(pictureBytes);
			
			materialserviceimpl.addMaterial(material);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	@PutMapping("/edit")
	public Material updateMaterial(@RequestParam("materialId") int materialId, @RequestParam("materialName") String materialName,@RequestParam("category") String category,
			@RequestParam("description") String description, @RequestParam("unitOfMeasure") String unitOfMeasure, 
			@RequestParam("unitPrice") double unitPrice,@RequestParam("quantity") int quantity,
			@RequestParam("dateOfPurchase") LocalDate dateOfLastPurchase,@RequestParam("expirationDate") LocalDate expirationDate, 
			@RequestParam(value="picture", required=false) MultipartFile picture) {
		try {
			byte[] pictureBytes = picture !=null? picture.getBytes():null;
			
			Material material = new Material(materialId, materialName, category,description,unitOfMeasure,unitPrice,quantity,dateOfLastPurchase,expirationDate,pictureBytes);
			materialserviceimpl.updateMaterial(material);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	@GetMapping("/all")
	public List<Material> getAllMaterials(){
		return materialserviceimpl.findAllMaterials();
	}
	
	@GetMapping("/{id}")
	public Material getMaterialById(@PathVariable int id) {
		return materialserviceimpl.findMaterialById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMaterial(@PathVariable int id) {
		materialserviceimpl.deleteMaterial(id);
	}
	
	
	
	

}
