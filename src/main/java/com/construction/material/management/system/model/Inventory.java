package com.construction.material.management.system.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

    @Column(nullable = false, unique = true)
    private String itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    @Column(name = "reorder_level", nullable = false)
    private Integer reorderLevel;

    @Column(name = "reorder_quantity", nullable = false)
    private Integer reorderQuantity;

    @Column(name = "date_of_last_purchase")
    private LocalDate dateOfLastPurchase;

    @Column(name = "date_of_last_sale")
    private LocalDate dateOfLastSale;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "batch_number_or_serial_number")
    private String batchNumberOrSerialNumber;

    

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	 public Inventory(Long inventoryId, String itemId, String itemName, Integer quantityInStock, Integer reorderLevel,
			Integer reorderQuantity, LocalDate dateOfLastPurchase, LocalDate dateOfLastSale, Status status,
			String batchNumberOrSerialNumber) {
		super();
		this.inventoryId = inventoryId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantityInStock = quantityInStock;
		this.reorderLevel = reorderLevel;
		this.reorderQuantity = reorderQuantity;
		this.dateOfLastPurchase = dateOfLastPurchase;
		this.dateOfLastSale = dateOfLastSale;
		this.status = status;
		this.batchNumberOrSerialNumber = batchNumberOrSerialNumber;
	}
	 



	public Long getInventoryId() {
		return inventoryId;
	}



	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public Integer getQuantityInStock() {
		return quantityInStock;
	}



	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}



	public Integer getReorderLevel() {
		return reorderLevel;
	}



	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}



	public Integer getReorderQuantity() {
		return reorderQuantity;
	}



	public void setReorderQuantity(Integer reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}



	public LocalDate getDateOfLastPurchase() {
		return dateOfLastPurchase;
	}



	public void setDateOfLastPurchase(LocalDate dateOfLastPurchase) {
		this.dateOfLastPurchase = dateOfLastPurchase;
	}



	public LocalDate getDateOfLastSale() {
		return dateOfLastSale;
	}



	public void setDateOfLastSale(LocalDate dateOfLastSale) {
		this.dateOfLastSale = dateOfLastSale;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public String getBatchNumberOrSerialNumber() {
		return batchNumberOrSerialNumber;
	}



	public void setBatchNumberOrSerialNumber(String batchNumberOrSerialNumber) {
		this.batchNumberOrSerialNumber = batchNumberOrSerialNumber;
	}




	public enum Status {
	        AVAILABLE,
	        OUT_OF_STOCK,
	        DISCONTINUED
	    }
	
    
	
	

}
