package com.ordermanagement.orderservice.dto;

import java.util.List;

public class OrderRequestDTO {

    private String username;
    private List<OrderItemDTO> items;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
