package com.demo.dto;

public class LineItemDTO {

    private String variantKey;
    private double price;
    private int quantity;
    private double totalPrice;
	public LineItemDTO() {
		super();
	}
	
	public LineItemDTO(String variantKey, double price, int quantity, double totalPrice) {
		super();
		this.variantKey = variantKey;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getVariantKey() {
		return variantKey;
	}
	public void setVariantKey(String variantKey) {
		this.variantKey = variantKey;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
   

    
}
