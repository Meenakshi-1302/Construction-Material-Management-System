package com.construction.material.management.system.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.Cart;
import com.construction.material.management.system.repository.CartRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CartRepoImpl implements CartRepository {

	
	
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public String addCart(Cart cart) {
		if(cart !=null) {
			entitymanager.persist(cart);
			return "success";
		}else {
			return "failure";
		}
	}

	@Override
	public String updateCart(Cart cart) {
		if(cart!=null) {
			entitymanager.merge(cart);
			return "success";
			
		}else {
			return "failure";
		}
	}

	@Override
	public String delete(Long id) {
		Cart cartid = entitymanager.find(Cart.class, id);
		entitymanager.remove(cartid);
		return "deleted";
	}

	@Override
	public List<Cart> findAllCarts() {
		String hql = "from Cart";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Cart findById(Long id) {
		return entitymanager.find(Cart.class, id);
	}

}
