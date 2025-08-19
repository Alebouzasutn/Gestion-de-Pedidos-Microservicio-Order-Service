package com.ordermanagement.orderservice.controller;

import com.ordermanagement.orderservice.dto.OrderRequestDTO;
import com.ordermanagement.orderservice.dto.OrderResponseDTO;
import com.ordermanagement.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint para crear un pedido, solo usuarios autenticados
    @PostMapping
    @PreAuthorize("hasRole('USER')") // Protege con JWT y rol USER
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request) {
        OrderResponseDTO response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }
}
