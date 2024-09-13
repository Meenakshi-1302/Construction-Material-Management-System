package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.Supplier;
import com.construction.material.management.system.repository.SupplierRepository;
import com.construction.material.management.system.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepository supplierrepository;

	@Override
	public String addSupplier(Supplier supplier) {
		if(supplier !=null) {
			System.out.println(supplier);
			supplierrepository.addSupplier(supplier);
			return "insertion success";
		}else {
			return "insertion failed";
		}
	}

	@Override
	public String updateSupplier(Supplier supplier) {
		
			supplierrepository.update(supplier);
			return "updation success";
		
	}

	@Override
	public String deleteSupplier(Long supplierId) {
		return supplierrepository.delete(supplierId);
		
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		return supplierrepository.findAllSuppliers();
	}

	@Override
	public Supplier findSupplierById(Long id) {
		return supplierrepository.findById(id);
	}

}
