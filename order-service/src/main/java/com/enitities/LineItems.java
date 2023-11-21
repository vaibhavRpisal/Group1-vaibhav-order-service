package com.enitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineItems {

	@Id
	@GeneratedValue(generator = "uuid")
	private Long LineItemsId;
	
	 @Column(name = "PRODUCT_ID")
	private int ProductKey;
	
	private int VarientKey;
	
	private int quentity;
	
	private double price;
	
	private double TotalPrice=price*quentity;
	
//	@ManyToOne
//	private Cart cart;
//


}
