package com.construction.material.management.system.repository;

import java.util.List;

import com.construction.material.management.system.model.Supplier;

public interface SupplierRepository {
	
	public String addSupplier(Supplier supplier);
	public String update(Supplier supplier);
	public String delete(Long supplierId);
	public List<Supplier> findAllSuppliers();
	public Supplier findById(Long supplierId);

}
