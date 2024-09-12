package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.Material;

public interface MaterialService {
	
	public String addMaterial(Material material);
	public String updateMaterial(Material material);
	public String deleteMaterial(int id);
	public List<Material> findAllMaterials();
	public Material findMaterialById(int id);
	
	
	

}
