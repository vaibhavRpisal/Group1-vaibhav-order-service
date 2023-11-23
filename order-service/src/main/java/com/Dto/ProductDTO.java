package com.Dto;

import java.util.Set;

public class ProductDTO {

	private Long id;
	private String productKey;
	private String productName;
	private String productDescription;

	public ProductDTO() {
		super();
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
