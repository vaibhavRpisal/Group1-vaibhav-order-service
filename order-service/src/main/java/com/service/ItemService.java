package com.service;

import java.util.List;

import com.enitities.Cart;
import com.enitities.LineItems;

public interface ItemService {

	public LineItems save(LineItems lineItems);
	public List<LineItems> getLineItems();
	public LineItems findLineItemsId(Long LineItemsId);
	public LineItems deleteLineItems(LineItems lineItems);
}
