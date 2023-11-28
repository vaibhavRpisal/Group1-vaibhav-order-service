package com.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Order entity
@Entity
public class Orders {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;


 private Long cartId;

 private double totalPrice;

 private String paymentStatus;

 private String orderStatus; 

public Orders() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}





public Long getCartId() {
	return cartId;
}

public void setCartId(Long cartId) {
	this.cartId = cartId;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

public String getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

 // Constructors, getters, setters
}
