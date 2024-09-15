package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.FormRequest;

public interface FormRequestService {
	
	public String addFormRequest(FormRequest formrequest);
	public String deleteFormRequest(Long id);
	public List<FormRequest> findAllFormRequests();
	public FormRequest findFormRequestById(Long id);

}
