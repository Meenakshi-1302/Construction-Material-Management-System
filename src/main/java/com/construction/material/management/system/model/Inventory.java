package com.construction.material.management.system.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column
    private String status;

    @Column(name = "batch_number_or_serial_number")
    private String batchNumberOrSerialNumber;
    
    @OneToOne
    @JoinColumn(name="materialId")
    private Material material;

    

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(Long inventoryId, int reorderLevel, String status, String batchNumberOrSerialNumber,
			Material material) {
		super();
		this.inventoryId = inventoryId;
		this.reorderLevel = reorderLevel;
		this.status = status;
		this.batchNumberOrSerialNumber = batchNumberOrSerialNumber;
		this.material = material;
	}
	
	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBatchNumberOrSerialNumber() {
		return batchNumberOrSerialNumber;
	}

	public void setBatchNumberOrSerialNumber(String batchNumberOrSerialNumber) {
		this.batchNumberOrSerialNumber = batchNumberOrSerialNumber;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	
    
	
	

}
