package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enitities.Cart;
import com.repositories.CartRepository;

@Service
public class CartServiceImpl implements Cart_Service {

	@Autowired
	private CartRepository cartRepo;
	
	public CartServiceImpl(CartRepository cartRepo) {
		super();
		this.cartRepo = cartRepo;
	}

	
	
	
	@Override
	public Cart save(Cart cart) {
		cartRepo.save(cart);
		return cart;
	}

	
	@Override
	public List<Cart> getCart() {
		
		return cartRepo.findAll();
	}


	@Override
	public Cart findCartById(Long id) {
	
		return cartRepo.findById(id).get();

	}

	@Override
	public Cart deleteCart(Cart cart) {
		cartRepo.delete(cart);
		return cart;
	}

}
