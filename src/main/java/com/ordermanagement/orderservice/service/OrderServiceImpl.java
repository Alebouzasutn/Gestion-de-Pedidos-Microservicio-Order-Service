package com.ordermanagement.orderservice.service;

import com.ordermanagement.orderservice.dto.OrderItemDTO;
import com.ordermanagement.orderservice.dto.OrderRequestDTO;
import com.ordermanagement.orderservice.dto.OrderResponseDTO;
import com.ordermanagement.orderservice.model.Order;
import com.ordermanagement.orderservice.model.OrderItem;
import com.ordermanagement.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        Order order = new Order();
        order.setUsername(request.getUsername());
        order.setCreatedAt(LocalDateTime.now());

        order.setItems(request.getItems().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            item.setProductName(itemDTO.getProductName());
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(itemDTO.getPrice());
            return item;
        }).collect(Collectors.toList()));

        order = orderRepository.save(order);

        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setUsername(order.getUsername());
        response.setCreatedAt(order.getCreatedAt());
        response.setItems(request.getItems());

        return response;
    }
}
