package com.construction.material.management.system.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.Supplier;
import com.construction.material.management.system.repository.SupplierRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public String addSupplier(Supplier supplier) {
		if(supplier !=null) {
			System.out.println(supplier);
			entitymanager.persist(supplier);
			return "success";
		}else {
			return "failed";
		}
	}

	@Override
	public String update(Supplier supplier) {
		if(supplier !=null) {
			entitymanager.merge(supplier);
			return "updated";
		}else {
			return "not updated";
		}
	}

	@Override
	public String delete(Long supplierId) {
		Supplier id = entitymanager.find(Supplier.class, supplierId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		String hql ="from Supplier";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Supplier findById(Long supplierId) {
		return entitymanager.find(Supplier.class, supplierId);
	}
	

}
