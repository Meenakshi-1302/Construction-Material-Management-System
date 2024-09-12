package com.construction.material.management.system.model;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	private Material material;
	
	private int quantity;
	
	private Integer price;
	
	private Long userId;
	
	public CartItem() {
		
	}

	public CartItem(Long id, Cart cart, Material material, int quantity, Integer price, Long userId) {
		super();
		this.id = id;
		this.cart = cart;
		this.material = material;
		this.quantity = quantity;
		this.price = price;
		this.userId = userId;
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id, price, material);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(material, other.material) ;
	}
	
	
}
