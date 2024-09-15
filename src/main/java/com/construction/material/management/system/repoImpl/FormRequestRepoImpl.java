package com.construction.material.management.system.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.FormRequest;
import com.construction.material.management.system.repository.FormRequestRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class FormRequestRepoImpl implements FormRequestRepository {

	
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public String addFormRequest(FormRequest formrequest) {
		if(formrequest !=null) {
			entitymanager.persist(formrequest);
			return "sent success";
		}else {
			return "sent failed";
		}
	}

	@Override
	public String delete(Long requestId) {
		FormRequest id = entitymanager.find(FormRequest.class, requestId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<FormRequest> findAllFormRequests() {
		String hql = "from FormRequest";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public FormRequest findById(Long requestId) {
		return entitymanager.find(FormRequest.class, requestId);
	}

}
