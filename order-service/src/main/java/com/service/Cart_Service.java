package com.service;

import java.util.List;

import com.enitities.Cart;

public interface Cart_Service {

	public void save(Cart cart);
	public List<Cart> getCart();
	
	public Cart findById(Long id);
	public void delete(Cart cart);
}
