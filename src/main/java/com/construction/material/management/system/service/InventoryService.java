package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.Inventory;

public interface InventoryService {
	
	public String addInventory(Inventory inventory);
	public String updateInventory(Inventory inventory);
	public String deleteInventory(Long id);
	public List<Inventory> findAllInventories();
	public Inventory findInventoryById(Long id);
	
	

}
