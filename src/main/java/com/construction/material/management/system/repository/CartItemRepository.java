package com.construction.material.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.construction.material.management.system.model.CartItem;

@Repository
	public interface CartItemRepository extends JpaRepository<CartItem, Long> {}


