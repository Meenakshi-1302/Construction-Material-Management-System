package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.Material;
import com.construction.material.management.system.repository.MaterialRepository;
import com.construction.material.management.system.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialRepository materialrepository;

	@Override
	public String addMaterial(Material material) {
		if(material!=null) {
			materialrepository.addMaterial(material);
			return "material added!";
		}else {
			return "material addition failed";
		}
	}

	@Override
	public String updateMaterial(Material material) {
		materialrepository.update(material);
		return "materail updated";
	}

	@Override
	public String deleteMaterial(int id) {
		return materialrepository.delete(id);
	}

	@Override
	public List<Material> findAllMaterials() {
		return materialrepository.findAllMaterials();
	}

	@Override
	public Material findMaterialById(int id) {
		return materialrepository.findById(id);
	}
	

}
