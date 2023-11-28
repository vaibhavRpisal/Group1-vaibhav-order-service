package com.demo.connect;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.dto.ProductVariantDto;

@FeignClient(name = "product-service", url = "http://localhost:1012/api/productVariant")
public interface ProductConnect {

	@GetMapping("/{productVariantKey}")
	public ResponseEntity<ProductVariantDto> getProductVariantByKey(@PathVariable String productVariantKey);
}
