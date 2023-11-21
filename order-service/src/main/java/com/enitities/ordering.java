package com.enitities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "buy")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ordering {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Buy_Id")
	private Long OrderId;
	
	@Column(name="CART_ID") 
	private Long CartId;
	
	@Column(name="TOTAL_PRICE")
	private Double TotalPrice;
	
	@Column(name="PAYMENT_STATUS")
	private String PaymentStatus;
	
	@Column(name="ORDER_STATUS")
	private String OrderStatus;
	
	
	
	
}
