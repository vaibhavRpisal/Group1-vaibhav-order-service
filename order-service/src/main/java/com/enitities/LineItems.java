package com.enitities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class LineItems {

	@Id
	@GeneratedValue(generator = "uuid")
	private Long LineItemsId;
	 @Column(name = "PRODUCT_ID")
	private String ProductKey;
	private int quentity;
	private double price;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;

	   @ManyToOne
	    @JoinColumn
	    private ordering order;

	   
	   
	   
	public Long getLineItemsId() {
		return LineItemsId;
	}

	public void setLineItemsId(Long lineItemsId) {
		LineItemsId = lineItemsId;
	}

	public String getProductKey() {
		return ProductKey;
	}

	public void setProductKey(String productKey) {
		ProductKey = productKey;
	}



	public int getQuentity() {
		return quentity;
	}

	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ordering getOrder() {
		return order;
	}

	public void setOrder(ordering order) {
		this.order = order;
	}

	public LineItems() {
		super();
	}

	public LineItems(Long lineItemsId, String productKey, int varientKey,  double price,
			Cart cart, ordering order) {
		super();
		LineItemsId = lineItemsId;
		ProductKey = productKey;
		
		this.quentity = quentity;
		this.price = price;
		
		this.cart = cart;
		this.order = order;
	}




}
