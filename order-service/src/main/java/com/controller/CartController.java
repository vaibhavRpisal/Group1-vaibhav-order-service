package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Dto.ProductDTO;
import com.client.ProductClient;
import com.enitities.Cart;
import com.repositories.CartRepository;
import com.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartServiceImpl cartservice;

	@Autowired
	private ProductClient productClient;

	
	
	
	@PostMapping
	public ResponseEntity<Cart> AddCart(@RequestBody Cart cart) {
		Cart savecart = cartservice.save(cart);		
		return new ResponseEntity<>(savecart, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Cart> getCart(){
		return	cartservice.getCart() ; 
	}
	
	@GetMapping("/{cartId}")
	public Cart cartById(@PathVariable Long cartId) {
		
	        return	cartservice.findCartById(cartId) ; 
	}
	
	@DeleteMapping("/{cartId}")
	public Cart deleteCart(@PathVariable Long cartId) {
		Cart cart = cartservice.findCartById(cartId);
		cartservice.deleteCart(cart);
		return cart;
	}
	
	
	
}
