package com.enitities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ORDERS")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
//	@OneToOne
//	private Cart cart;
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<LineItems>lineItems;
	
}
