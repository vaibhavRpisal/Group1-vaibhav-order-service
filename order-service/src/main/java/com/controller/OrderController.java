package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enitities.Cart;
import com.enitities.ordering;
import com.service.OrderServiceImpl;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;
	
	
	@PostMapping
	public ResponseEntity<ordering> AddOrder(@RequestBody ordering order) {
		ordering saveOrder = orderService.save(order);
		return new ResponseEntity<>(saveOrder, HttpStatus.OK);
	}
	@GetMapping
	public List<ordering> getOrder(){
		return	orderService.getOrders() ; 
	}
	
	@GetMapping("{OrderId}")
	public ordering orderById(@PathVariable Long OrderId) {
		return	orderService.findOrderById(OrderId) ; 
	}
	
	@DeleteMapping("{OrderId}")
	public ordering deleteCart(@PathVariable Long OrderId) {
		ordering order = orderService.findOrderById(OrderId);
		orderService.deleteOrder(order);
		return order;
	}
}
