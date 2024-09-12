package com.construction.material.management.system.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.Material;
import com.construction.material.management.system.repository.MaterialRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MaterialRepoImpl implements MaterialRepository {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public String addMaterial(Material material) {
		if(material!=null) {
			entitymanager.persist(material);
			return "success";
		} else {
			return "insertion failed";
		}
	}

	@Override
	public String update(Material material) {
		if(material!=null) {
			entitymanager.merge(material);
			return "updated";
		}else {
			return "updation failed";
		}
	}

	@Override
	public String delete(int materialId) {
		Material id = entitymanager.find(Material.class, materialId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Material> findAllMaterials() {
		String hql = "from Material";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
		
	}

	@Override
	public Material findById(int materialId) {
		return entitymanager.find(Material.class, materialId);
	}

}
