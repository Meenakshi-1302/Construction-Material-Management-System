package com.construction.material.management.system.repository;

import java.util.List;

import com.construction.material.management.system.model.Inventory;

public interface InventoryRepository {
	
	public String addInventory(Inventory inventory);
	public String update(Inventory inventory);
	public String delete(Long inventoryId);
	public List<Inventory> findAllInventories();
	public Inventory findById(Long inventoryId);
	

}
