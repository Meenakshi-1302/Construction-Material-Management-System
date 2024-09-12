package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.AdministrativeUser;



public interface AdministrativeUserService {
	
	AdministrativeUser saveAdministrativeUser(AdministrativeUser user);
    AdministrativeUser getAdministrativeUserById(int id);
    List<AdministrativeUser> getAllAdministrativeUsers();
    void deleteAdministrativeUser(int userId);
    AdministrativeUser updateAdministrativeUser(AdministrativeUser user);

}
