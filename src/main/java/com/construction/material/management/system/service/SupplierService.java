package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.Supplier;

public interface SupplierService {
	
	public String addSupplier(Supplier supplier);
	public String updateSupplier(Supplier supplier);
	public String deleteSupplier(Long supplierId);
	public List<Supplier> findAllSuppliers();
	public Supplier findSupplierById(Long id);
	
	

}
