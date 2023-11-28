package com.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.dto.CartDTO;
import com.demo.dto.LineItemDTO;

public interface CartService {
	ResponseEntity<CartDTO> createCart(CartDTO cartDTO);

    ResponseEntity<CartDTO> getCartById(Long cartId);

    ResponseEntity<List<CartDTO>> getAllCarts();

    ResponseEntity<Void> updateCart(Long cartId, CartDTO cartDTO);

    ResponseEntity<Void> deleteCart(Long cartId);
}

