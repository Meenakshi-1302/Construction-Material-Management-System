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
@Table(name="Form Request ")
public class FormRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
	
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;
	
	@Column(name="Unit")
	private int unit;
	
	@Column(name="total amount")
	private double totalAmount;
	
	@Column(name="Address")
	private String Address;

	public FormRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormRequest(long requestId, Supplier supplier, int unit, double totalAmount, String address) {
		super();
		this.requestId = requestId;
		this.supplier = supplier;
		this.unit = unit;
		this.totalAmount = totalAmount;
		Address = address;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	

}
