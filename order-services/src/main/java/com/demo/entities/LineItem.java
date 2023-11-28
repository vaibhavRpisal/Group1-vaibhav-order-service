package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//LineItem entity
@Entity
public class LineItem {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String variantKey;

 private double price;

 private int quantity;

 private double totalPrice;

 @ManyToOne
 @JoinColumn(name = "cart_id")
 private Cart cart;

public LineItem() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public String getVariantKey() {
	return variantKey;
}

public void setVariantKey(String variantKey) {
	this.variantKey = variantKey;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}
 
 


}
