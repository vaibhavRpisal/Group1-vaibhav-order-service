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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CART")

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Long CartId;

	@Column(name = "CUSTOMER_ID")
	private Long CustomerId;

	@Column(name = "TOTAL_PRICE")
	private double TotalPrice;

	@Column(name = "CART_STATUS")
	private String CartStatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart" )
	private Set<LineItems> lineItems;

	public Long getCartId() {
		return CartId;
	}

	public Cart(Long cartId, Long customerId, double totalPrice, String cartStatus, Set<LineItems> lineItems) {
		super();
		CartId = cartId;
		CustomerId = customerId;
		TotalPrice = totalPrice;
		CartStatus = cartStatus;
		this.lineItems = lineItems;
	}

	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", CustomerId=" + CustomerId + ", TotalPrice=" + TotalPrice + ", CartStatus="
				+ CartStatus + ", lineItems=" + lineItems + "]";
	}

	public void setCartId(Long cartId) {
		CartId = cartId;
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}

	public double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getCartStatus() {
		return CartStatus;
	}

	public void setCartStatus(String cartStatus) {
		CartStatus = cartStatus;
	}

	public Set<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}

	public Cart() {
		super();
	}

}
