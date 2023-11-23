package com.controller;



import jakarta.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Dto.ProductDTO;
import com.client.ProductClient;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductClient productClient;
    



    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOList = productClient.getAllProducts();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productClient.getProductById(id);
        String errorMessage = "Product not found for id: " + id;
        
        return productDTO != null
                ? new ResponseEntity<>(productDTO, HttpStatus.OK)
                : new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
   
  
    @GetMapping("/key/{productKey}")
    public ResponseEntity<ProductDTO> getProductByKey(@PathVariable("productKey") String productKey) {
        ProductDTO productDto = productClient.getProductByProductKey(productKey);
        
        if (productDto != null) {
        	return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else {
        	
            return ResponseEntity.notFound().build();
        }
    }
    



}

