package com.construction.material.management.system.repository;

import java.util.List;

import com.construction.material.management.system.model.FormRequest;

public interface FormRequestRepository {
	public String addFormRequest(FormRequest formrequest);
	public String delete(Long requestId);
	public List<FormRequest> findAllFormRequests();
	public FormRequest findById(Long requestId);
	

}
