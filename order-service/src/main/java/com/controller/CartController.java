package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enitities.Cart;
import com.repositories.CartRepository;
import com.service.CartServiceImpl;

@RestController
public class CartController {

	@Autowired
	private CartServiceImpl cartservice;
//	@Autowired
//	private CartRepository cartrepository;
//	

	@PostMapping("/save")
	public Cart AddCart(@RequestBody Cart cart) {
		cartservice.save(cart);
		return cart;
	}

}
