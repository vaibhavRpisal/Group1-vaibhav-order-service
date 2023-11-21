package com.service;

import java.util.List;

import com.enitities.Cart;


public interface Cart_Service {

	public Cart save(Cart cart);
	public List<Cart> getCart();
	public Cart findCartById(Long id);
	public Cart deleteCart(Cart cart);
	
}
