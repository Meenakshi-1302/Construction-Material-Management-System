package com.construction.material.management.system.repository;

import java.util.List;

import com.construction.material.management.system.model.Material;

public interface MaterialRepository {
	
	public String addMaterial(Material material);
	public String update(Material material);
	public String delete(int materialId);
	public List<Material> findAllMaterials();
	public Material findById(int materialId);
	

}
