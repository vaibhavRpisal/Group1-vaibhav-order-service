package com.service;

import java.util.List;

import com.enitities.Cart;
import com.enitities.ordering;

public interface OrderService {

	
	public ordering save(ordering order);
	public List<ordering> getOrders();
	public ordering findOrderById(Long OrderId);
	public ordering deleteOrder(ordering order);
}
