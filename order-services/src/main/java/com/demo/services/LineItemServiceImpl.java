package com.demo.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.connect.ProductConnect;
import com.demo.dto.LineItemDTO;
import com.demo.dto.Price;
import com.demo.dto.ProductVariantDto;
import com.demo.entities.Cart;
import com.demo.entities.LineItem;
import com.demo.repositories.CartRepository;
import com.demo.repositories.LineItemRepository;

@Service
public class LineItemServiceImpl implements LineItemService {

    private final CartRepository cartRepository;
    private final LineItemRepository lineItemRepository;
    private final ModelMapper modelMapper;
    private final ProductConnect productConnect;

    @Autowired
    public LineItemServiceImpl(CartRepository cartRepository, LineItemRepository lineItemRepository,
			ModelMapper modelMapper, ProductConnect productConnect) {
		super();
		this.cartRepository = cartRepository;
		this.lineItemRepository = lineItemRepository;
		this.modelMapper = modelMapper;
		this.productConnect = productConnect;
	}


    @Override
    public ResponseEntity<LineItemDTO> addLineItem(Long cartId, String variantKey, int quantity) {
        Cart cart = getCartEntityById(cartId);

        ResponseEntity<ProductVariantDto> responseProductVariantDto = productConnect.getProductVariantByKey(variantKey);
        
        LineItem lineItem = new LineItem();
        lineItem.setCart(cart);
        lineItem.setVariantKey(variantKey);
        lineItem.setQuantity(quantity);
        Set<Price> price = responseProductVariantDto.getBody().getPrices();
        Price firstPrice = price.stream().findFirst().orElse(null);
        lineItem.setPrice(firstPrice.getCentAmount());
        
        lineItem.setTotalPrice(firstPrice.getCentAmount()*quantity);
        
        cart.getLineItems().add(lineItem);
        cart.setTotalPrice(cart.getTotalPrice() + lineItem.getTotalPrice());

        cartRepository.save(cart);

        LineItemDTO addedLineItemDTO = modelMapper.map(lineItem, LineItemDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLineItemDTO);
    }

    
	@Override
    public ResponseEntity<Void> removeLineItem(Long cartId, Long lineItemId) {
        Cart cart = getCartEntityById(cartId);

        boolean itemRemoved = cart.getLineItems().removeIf(item -> item.getId().equals(lineItemId));
        if (itemRemoved) {
            cart.setTotalPrice(cart.getLineItems().stream().mapToDouble(LineItem::getTotalPrice).sum());
            cartRepository.save(cart);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<LineItemDTO>> getLineItemsByCartId(Long cartId) {
        List<LineItem> lineItems = getCartEntityById(cartId).getLineItems();
        List<LineItemDTO> lineItemDTOs = lineItems.stream().map(lineItem -> modelMapper.map(lineItem, LineItemDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(lineItemDTOs);
    }

    @Override
    public ResponseEntity<LineItemDTO> updateLineItem(Long cartId, Long lineItemId, LineItemDTO lineItemDTO) {
        Cart cart = getCartEntityById(cartId);

        LineItem existingLineItem = getLineItemEntityById(lineItemId);

        // Update fields based on your requirements
        modelMapper.map(lineItemDTO, existingLineItem);

        cart.setTotalPrice(cart.getLineItems().stream().mapToDouble(LineItem::getTotalPrice).sum());
        cartRepository.save(cart);

        LineItemDTO updatedLineItemDTO = modelMapper.map(existingLineItem, LineItemDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLineItemDTO);
    }

    @Override
    public ResponseEntity<LineItemDTO> getLineItemById(Long cartId, Long lineItemId) {
        LineItem lineItem = getLineItemEntityById(lineItemId);
        LineItemDTO lineItemDTO = modelMapper.map(lineItem, LineItemDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(lineItemDTO);
    }

    private Cart getCartEntityById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));
    }

    private LineItem getLineItemEntityById(Long lineItemId) {
        return lineItemRepository.findById(lineItemId)
                .orElseThrow(() -> new RuntimeException("LineItem not found with id: " + lineItemId));
    }
}
