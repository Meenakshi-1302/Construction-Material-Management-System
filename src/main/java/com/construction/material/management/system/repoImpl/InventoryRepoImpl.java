package com.construction.material.management.system.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.Inventory;
import com.construction.material.management.system.repository.InventoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InventoryRepoImpl implements InventoryRepository {

	
	
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public String addInventory(Inventory inventory) {
		if(inventory!=null) {
			entitymanager.persist(inventory);
			return "insertion success";
		}else {
			return "insertion failed";
		}
	}

	@Override
	public String update(Inventory inventory) {
		if(inventory!=null) {
			entitymanager.merge(inventory);
			return "updation success";
		}else {
			return "updation failed";
		}
	}

	@Override
	public String delete(Long inventoryId) {
		Inventory id = entitymanager.find(Inventory.class, inventoryId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Inventory> findAllInventories() {
		String hql = "from Inventory";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Inventory findById(Long inventoryId) {
		return entitymanager.find(Inventory.class, inventoryId);
	}
	
	

}
