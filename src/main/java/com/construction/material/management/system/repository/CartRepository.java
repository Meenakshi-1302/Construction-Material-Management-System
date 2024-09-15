package com.construction.material.management.system.repository;

import java.util.List;

import com.construction.material.management.system.model.Cart;


public interface CartRepository {
	public String addCart(Cart cart);
	public String updateCart(Cart cart);
	public String delete(Long id);
	public List<Cart> findAllCarts();
	public Cart findById(Long id);

}
