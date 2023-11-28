package com.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.connect.PaymentConnect;
import com.demo.dto.OrderDTO;
import com.demo.dto.PaymentDto;
import com.demo.entities.Cart;
import com.demo.entities.Orders;
import com.demo.repositories.CartRepository;
import com.demo.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;
    private final PaymentConnect paymentConnect;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper,CartRepository cartRepository,PaymentConnect paymentConnect) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.cartRepository = cartRepository;
        this.paymentConnect = paymentConnect;
    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(Long userId, OrderDTO orderDTO) {
        Orders order = modelMapper.map(orderDTO, Orders.class);
        
        List<Cart> cart = cartRepository.findByUserId(userId);
        Cart firstCart = cart.stream().findFirst().orElse(null);
       
        order.setTotalPrice(firstCart.getTotalPrice());
        order.setId(userId);
        order.setPaymentStatus("DONE");
       
        orderRepository.save(order);
        
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderId(order.getId());
        paymentDto.setAmount(firstCart.getTotalPrice());
        paymentDto.setPaymentMethod("UPI");
        paymentDto.setPaymentStatus("SUCCESSFUL");
        ResponseEntity<PaymentDto> responsePaymentDto = paymentConnect.processPayment(paymentDto);

        OrderDTO createdOrderDTO = modelMapper.map(order, OrderDTO.class);
        
        
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDTO);
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(Long orderId) {
        Orders order = getOrderEntityById(orderId);
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(Long userId) {
        Optional<Orders> orders = orderRepository.findById(userId);
        List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOs);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOs);
    }

    @Override
    public ResponseEntity<Void> updateOrder(Long orderId, OrderDTO orderDTO) {
        Orders existingOrder = getOrderEntityById(orderId);

        // Update fields based on your requirements
        modelMapper.map(orderDTO, existingOrder);

        orderRepository.save(existingOrder);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        Orders order = getOrderEntityById(orderId);
        orderRepository.delete(order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private Orders getOrderEntityById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }
}
