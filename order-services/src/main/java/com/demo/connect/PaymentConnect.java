package com.demo.connect;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.dto.PaymentDto;


@FeignClient(name = "payment-service", url = "http://localhost:1014/api/payment")
public interface PaymentConnect {
 
	@PostMapping
	public ResponseEntity<PaymentDto> processPayment(@RequestBody PaymentDto dto);
	
	@GetMapping("/id/{id}")
	public ResponseEntity<PaymentDto> getPaymentInfo(@PathVariable("id") long paymentId);
}
