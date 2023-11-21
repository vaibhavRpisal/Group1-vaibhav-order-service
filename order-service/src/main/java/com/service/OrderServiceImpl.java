package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enitities.Cart;
import com.enitities.ordering;
import com.repositories.OrderingRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderingRepository orderRepo;

	public OrderServiceImpl() {
	}

	@Override
	public ordering save(ordering order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public List<ordering> getOrders() {
		return orderRepo.findAll();
	}

	@Override
	public ordering findOrderById(Long OrderId) {
		return orderRepo.findById(OrderId).get();

	}

	@Override
	public ordering deleteOrder(ordering order) {
		orderRepo.delete(order);
		return order;
	}

}
