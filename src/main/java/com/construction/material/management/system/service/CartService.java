package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.Cart;


public interface CartService {
	public String addCart(Cart cart);
	public String updateCart(Cart cart);
	public String deleteCart(Long id);
	public List<Cart> findAllCarts();
	public Cart findCartById(Long id);
	
	

}
