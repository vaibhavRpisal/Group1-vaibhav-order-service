package com.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Dto.ProductDTO;

@FeignClient(name="product-service", url="http://localhost:9092/api")
public interface ProductClient {

	@GetMapping("/products/{id}")
	ProductDTO getProductById(@PathVariable Long id); 

	@GetMapping("/products/{productKey}")
	ProductDTO getProductByProductKey(@PathVariable Long productKey); 
}
