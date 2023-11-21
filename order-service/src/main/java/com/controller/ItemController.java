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
import com.enitities.LineItems;
import com.enitities.ordering;
import com.service.ItemServiceImpl;

@RequestMapping("/items")
@RestController
public class ItemController {

	@Autowired
	private ItemServiceImpl itemsService;
	
	@PostMapping
	public ResponseEntity<LineItems> AddItems(@RequestBody LineItems lineItems ) {
		LineItems saveItems = itemsService.save(lineItems);
		return new ResponseEntity<>(saveItems, HttpStatus.OK);
	}
	
	@GetMapping
	public List<LineItems> getLineitems(){
		return	itemsService.getLineItems() ; 
	}
	
	@GetMapping("/{LineItemsId}")
	public LineItems LineItemById(@PathVariable Long lineItems) {
		return	itemsService.findLineItemsId(lineItems) ; 
	}
	
	@DeleteMapping("/{LineItemsId}")
	public LineItems deleteLineItems(@PathVariable Long LineItemsId) {
		LineItems Items = itemsService.findLineItemsId(LineItemsId);
		itemsService.deleteLineItems(Items);
		return Items;
	}
	
}
