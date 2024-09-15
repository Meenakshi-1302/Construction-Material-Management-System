package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.Cart;
import com.construction.material.management.system.repository.CartRepository;
import com.construction.material.management.system.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartrepository;
	
	@Override
	public String addCart(Cart cart) {
		if(cart !=null) {
			cartrepository.addCart(cart);
			return "added";
			
		}else {
			return "not added";
		}
		
	}

	@Override
	public String updateCart(Cart cart) {
		cartrepository.updateCart(cart);
		return "updated";
	}

	@Override
	public String deleteCart(Long id) {
		return cartrepository.delete(id);
	}

	@Override
	public List<Cart> findAllCarts() {
		return cartrepository.findAllCarts();
	}

	@Override
	public Cart findCartById(Long id) {
		return cartrepository.findById(id);
	}

}
