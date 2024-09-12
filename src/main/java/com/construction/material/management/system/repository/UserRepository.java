package com.construction.material.management.system.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public User findById(Long id) {
		return entityManager.find(User.class, id);
		
	}
	
	public List<User> findAll(){
		return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
	}
	
	public User save(User user) {
		entityManager.persist(user);
		return user;
	}
	
	public User update(User user) {
		return entityManager.merge(user);
	}
	
	public void delte(Long id) {
		User user = findById(id);
		if(user != null) {
			entityManager.remove(user);
		}
	}
	
	

}
