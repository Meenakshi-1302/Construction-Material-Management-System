package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.Inventory;
import com.construction.material.management.system.repository.InventoryRepository;
import com.construction.material.management.system.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public String addInventory(Inventory inventory) {
		
			if(inventory!=null) {
				inventoryRepository.addInventory(inventory);
				return "inventory added";
			} else {
				return "inventory addition failed";
		}
	}

	@Override
	public String updateInventory(Inventory inventory) {
		inventoryRepository.update(inventory);
		return "inventory updated";
	}

	@Override
	public String deleteInventory(Long id) {
		return inventoryRepository.delete(id);
	}

	@Override
	public List<Inventory> findAllInventories() {
		return inventoryRepository.findAllInventories();	}

	@Override
	public Inventory findInventoryById(Long id) {
		return inventoryRepository.findById(id);
	}

}
