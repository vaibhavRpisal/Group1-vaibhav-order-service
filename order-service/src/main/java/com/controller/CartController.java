package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enitities.Cart;
import com.repositories.CartRepository;
import com.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartServiceImpl cartservice;
	


	@PostMapping("/hi")
	public String hi(){
		return "hello";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Cart> AddCart(@RequestBody Cart cart) {
		Cart savecart = cartservice.save(cart);
		
		return new ResponseEntity<>(savecart, HttpStatus.OK);
	}
	
	@GetMapping("/cart")
	public List<Cart> getCart(){
		return	cartservice.getCart() ; 
	}
	
	@GetMapping("/{cartId}")
	public Cart cartById(@RequestParam Long cartId) {
		return	cartservice.findCartById(cartId) ; 
	}
	
	@DeleteMapping("/delete/{cartId}")
	public Cart deleteCart(@RequestBody Long cartId) {
		Cart cart = cartservice.findCartById(cartId);
		cartservice.deleteCart(cart);
		return cart;
	}
	
	
	
}
