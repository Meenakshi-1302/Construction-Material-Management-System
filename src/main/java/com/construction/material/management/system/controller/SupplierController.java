package com.construction.material.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.construction.material.management.system.model.Material;
import com.construction.material.management.system.model.Supplier;
import com.construction.material.management.system.serviceImpl.EmailServiceImpl;
import com.construction.material.management.system.serviceImpl.MaterialServiceImpl;
import com.construction.material.management.system.serviceImpl.SupplierServiceImpl;



@RestController
@RequestMapping("/suppliers")
@CrossOrigin("*")
public class SupplierController {
	
	@Autowired
	private SupplierServiceImpl supplierserviceimpl;
	@Autowired
	private MaterialServiceImpl materialserviceimpl;
	
	@Autowired
	private EmailServiceImpl emailserviceimpl;
	
	@PostMapping
    public Supplier createSupplier(
            @RequestParam("supplierName") String supplierName,
            @RequestParam("materialQuality") String materialQuality,
            @RequestParam("location") String location,
            @RequestParam("estimatedDeliveryDate") String estimatedDeliveryDate,
            @RequestParam("email") String email,
            @RequestParam("contactNumber") String contactNumber,
            @RequestParam("password") String password,
            @RequestParam("materialId") int materialId) {

        // Fetch the material from the database
        Material material = materialserviceimpl.findMaterialById(materialId);

        // Create a new Supplier instance
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierName);
        supplier.setMaterialQuality(materialQuality);
        supplier.setLocation(location);
        supplier.setEstimatedDeliveryDate(estimatedDeliveryDate);
        supplier.setEmail(email);
        supplier.setPassword(password);
        supplier.setContactNumber(contactNumber);
        supplier.setMaterial(material);

        // Save the supplier using the service
        supplierserviceimpl.addSupplier(supplier);

        return supplier;
    }
	@PostMapping("/sendmail")
	public ResponseEntity<String> sendEmail(@RequestBody Supplier request) {
	    try {
	        // Extract details from the request
	        String recipientEmail = request.getEmail();
	        String name = request.getSupplierName();
	        String pwd = request.getPassword();
	        
//	        String winningPrice = Double.toString(  request.getProduct().getCurrentBiddingPrice());
	 
	        // Create email subject and body
	        String subject = "Welcome to CMS ! Your Login Credentials";
//	        String text = String.format("Dear %s,\n\nCongratulations! You have won the auction for the product '%s' with a winning bid of %s.\n\nThank you for participating!\n\nBest Regards,\n AAA Auction Team",winner, productName, winningPrice);
	        String body = String.format("Dear %s,\n\n"
	        	    + "Welcome to  CMS !\n\n"
	        	    + "We are excited to have you on board. To get you started, please find your login credentials below:\n\n"
	        	    + "Username: %s \n\n"
	        	    + "Temporary Password: %s \n\n"
	        	    + "For your first login, please follow these steps:\n\n"
	        	    + "1. Visit our website , Login with the attached credentials\n"
	        	    + "2. Enter your username and temporary password.\n"
	        	    + "3. You will be prompted to change your temporary password. Please choose a strong, secure password that you have not used before.\n\n"
	        	    + "If you encounter any issues or need assistance, please do not hesitate to contact our IT support team at Cmsconstruction12@itsupport.com or  +91 9087124365.\n\n"
	        	    + "Once again, welcome to our Organization ! We look forward to working with you.\n\n"
	        	    + "Best regards,\n\n"
	        	    + "\n"
	        	    + "Admin Team\n"
	        	    + "CMS\n"
	        	    + "",name,recipientEmail,pwd);
	        // Send the email
	        emailserviceimpl.sendEmail(recipientEmail, subject, body);
	 
	        return ResponseEntity.ok("Email sent successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
	    }
	}
	
	
	@PutMapping
	public String updateSupplier(@RequestBody Supplier supplier) {
		String msg="";
		try {
			supplierserviceimpl.updateSupplier(supplier);
			msg="updated";
		}catch(Exception e) {
			msg="not updated";
			
		}
		return msg;
	}
	@GetMapping("{supplierId}")
	public Supplier getSupplierById(@PathVariable("supplierId") Long id) {
		return supplierserviceimpl.findSupplierById(id);
	}
	
	@GetMapping("/all")
	public List<Supplier> getSuppliers(){
		return supplierserviceimpl.findAllSuppliers();
	}
	
	@DeleteMapping
	public String deleteSupplier(@PathVariable("supplierId") Long id) {
		String msg="";
		try {
			supplierserviceimpl.deleteSupplier(id);
			return "deleted";
		}catch(Exception e) {
			msg="not deleted";
		}
		return msg;
	}
	

}
