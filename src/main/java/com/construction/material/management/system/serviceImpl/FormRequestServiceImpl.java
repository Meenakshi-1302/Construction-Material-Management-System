package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.FormRequest;
import com.construction.material.management.system.repository.FormRequestRepository;
import com.construction.material.management.system.service.FormRequestService;

@Service
public class FormRequestServiceImpl implements FormRequestService {

	
	@Autowired
	FormRequestRepository formrequestrepository;
	
	@Override
	public String addFormRequest(FormRequest formrequest) {
		if(formrequest !=null) {
			formrequestrepository.addFormRequest(formrequest);
			return "success";
		}else {
			return "failed";
		}
		
	}

	@Override
	public String deleteFormRequest(Long id) {
		return formrequestrepository.delete(id);
	}

	@Override
	public List<FormRequest> findAllFormRequests() {
		return formrequestrepository.findAllFormRequests();
	}

	@Override
	public FormRequest findFormRequestById(Long id) {
		return formrequestrepository.findById(id);
	}

}
