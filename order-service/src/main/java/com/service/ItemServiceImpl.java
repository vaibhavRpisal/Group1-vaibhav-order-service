package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enitities.LineItems;
import com.repositories.CartRepository;
import com.repositories.LineItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private LineItemRepository itemRepo;
	@Autowired
	private CartRepository cartRepo; 

	public ItemServiceImpl() {
		super();
	}

	@Override
	public LineItems save(LineItems lineItems) {
	
		
		itemRepo.save(lineItems);
		return lineItems;
	}

	@Override
	public List<LineItems> getLineItems() {
		return itemRepo.findAll();
	}

	@Override
	public LineItems findLineItemsId(Long LineItemsId) {
		return itemRepo.findById(LineItemsId).get();
	}

	@Override
	public LineItems deleteLineItems(LineItems lineItems) {
		itemRepo.delete(lineItems);
		return lineItems;
	}

	@Override
	public LineItems findItemsByCartId(Long CartId) {		
		return itemRepo.findById(CartId).get();
	}

}
