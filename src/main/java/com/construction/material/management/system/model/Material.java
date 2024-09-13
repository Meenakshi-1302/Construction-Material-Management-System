package com.construction.material.management.system.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int materialId;

    @Column(nullable = false, unique = true)
    private String materialName;

    @Column(nullable = false)
    private String category;

    private String description;

    @Column(name = "unit_of_measure", nullable = false)
    private String unitOfMeasure;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;
    
    @Column(name="Quantity")
    private int quantity;

    @Column(name = "date_of_last_purchase")
    private LocalDate dateOfLastPurchase;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB",length = 100000000)
    private byte[] picture;
    
    

	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Material(int materialId, String materialName, String category, String description,
			String unitOfMeasure, Double unitPrice,int quantity, LocalDate dateOfLastPurchase, LocalDate expirationDate,
			 byte[] picture) {
		super();
		
		this.materialId = materialId;
		this.materialName = materialName;
		this.category = category;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.dateOfLastPurchase = dateOfLastPurchase;
		this.expirationDate = expirationDate;
		this.picture = picture;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDateOfLastPurchase() {
		return dateOfLastPurchase;
	}

	public void setDateOfLastPurchase(LocalDate dateOfLastPurchase) {
		this.dateOfLastPurchase = dateOfLastPurchase;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	

    

}

