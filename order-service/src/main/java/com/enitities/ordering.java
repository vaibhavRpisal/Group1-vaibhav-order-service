package com.enitities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ORDERS")

@Entity

@Builder
public class ordering {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_Id")
	private Long OrderId;
	
	@Column(name="TOTAL_PRICE")
	private Double TotalPrice;
	
	@Column(name="PAYMENT_STATUS")
	private String PaymentStatus;
	
	@Column(name="ORDER_STATUS")
	private String OrderStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<LineItems>lineItems;

	
	public ordering() {
		
	}
	
	
	
	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public Double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Set<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

	public ordering(Long orderId, Double totalPrice, String paymentStatus, String orderStatus, Cart cart,
			Set<LineItems> lineItems) {
		super();
		OrderId = orderId;
		TotalPrice = totalPrice;
		PaymentStatus = paymentStatus;
		OrderStatus = orderStatus;
		this.cart = cart;
		this.lineItems = lineItems;
	}
	
	
}
