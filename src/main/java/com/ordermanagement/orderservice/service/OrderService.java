package com.ordermanagement.orderservice.service;

import com.ordermanagement.orderservice.dto.OrderRequestDTO;
import com.ordermanagement.orderservice.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);
}
