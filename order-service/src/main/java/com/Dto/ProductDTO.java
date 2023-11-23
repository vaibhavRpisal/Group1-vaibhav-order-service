package com.Dto;

import java.util.Set;

public class ProductDTO {

	private Long id;
	private String productKey;
	private String productName;
	private String productDescription;
	private double price;
	public ProductDTO() {
		super();
	}

	

	public ProductDTO(Long id, String productKey, String productName, String productDescription, double price) {
		super();
		this.id = id;
		this.productKey = productKey;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
