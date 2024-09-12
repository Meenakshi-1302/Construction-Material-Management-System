package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.AdministrativeUser;
import com.construction.material.management.system.repository.AdministrativeUserRepository;
import com.construction.material.management.system.service.AdministrativeUserService;


@Service
public class AdministartiveUserServiceImpl implements AdministrativeUserService {
	

    @Autowired
    private AdministrativeUserRepository administrativeUserRepository;
 
    @Override
	
     public AdministrativeUser saveAdministrativeUser(AdministrativeUser administrativeUser) {
        return administrativeUserRepository.save(administrativeUser);
    }
 
    @Override
    public AdministrativeUser updateAdministrativeUser(AdministrativeUser administrativeUser) {
        if (administrativeUserRepository.findById(administrativeUser.getAdminUserId()) != null) {
            return administrativeUserRepository.save(administrativeUser);
        } else {
            throw new IllegalArgumentException("AdministrativeUser with ID " + administrativeUser.getAdminUserId() + " does not exist.");
        }
    }
 
    @Override
    public void deleteAdministrativeUser(int adminUserId) {
        if (administrativeUserRepository.findById(adminUserId) != null) {
            administrativeUserRepository.delete(adminUserId);
        } else {
            throw new IllegalArgumentException("AdministrativeUser with ID " + adminUserId + " does not exist.");
        }
    }
 
    @Override
    public AdministrativeUser getAdministrativeUserById(int adminUserId) {
        return administrativeUserRepository.findById(adminUserId);
    }
 
    @Override
    public List<AdministrativeUser> getAllAdministrativeUsers() {
        return administrativeUserRepository.findAll();
    }

	
	

}
