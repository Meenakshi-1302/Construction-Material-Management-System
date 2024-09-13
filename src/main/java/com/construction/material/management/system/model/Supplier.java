package com.construction.material.management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	
	@Column(name="supplierName")
	private String supplierName;
	
	@Column(name="Quality")
	private String materialQuality;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="estimated delivery date")
	private String estimatedDeliveryDate;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Contact Number")
	private String contactNumber;
	
	@Column(name="Password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="MaterialId")
	private Material material;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(long supplierId, String supplierName, String materialQuality, String location,
			String estimatedDeliveryDate, String email, String contactNumber,String password, Material material) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.materialQuality = materialQuality;
		this.location = location;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.material = material;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getMaterialQuality() {
		return materialQuality;
	}

	public void setMaterialQuality(String materialQuality) {
		this.materialQuality = materialQuality;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	

}
