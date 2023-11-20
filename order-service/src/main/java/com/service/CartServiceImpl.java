package com.service;

import java.util.List;

import com.enitities.Cart;
import com.repositories.CartRepository;

public class CartServiceImpl implements Cart_Service {

	private CartRepository cartRepo;
	
	@Override
	public void save(Cart cart) {
		cartRepo.save(cart);
		
	}

	@Override
	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
