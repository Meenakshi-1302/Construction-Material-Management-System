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
@Table(name="Logistics")
public class Logistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Month")
	private String month;
	
	@ManyToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="requestId")
	private FormRequest formRequest;
	
	@Column(name="Net Profit")
	private double profit;
	
	@Column(name="notes")
	private String notes;

	public Logistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logistics(long id, String month, Payment payment, FormRequest formRequest, double profit, String notes) {
		super();
		this.id = id;
		this.month = month;
		this.payment = payment;
		this.formRequest = formRequest;
		this.profit = profit;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public FormRequest getFormRequest() {
		return formRequest;
	}

	public void setFormRequest(FormRequest formRequest) {
		this.formRequest = formRequest;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	

}
