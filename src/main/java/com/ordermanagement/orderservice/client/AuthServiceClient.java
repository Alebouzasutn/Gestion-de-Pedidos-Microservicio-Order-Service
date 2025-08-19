package com.ordermanagement.orderservice.client;

import com.ordermanagement.orderservice.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", url = "http://localhost:8080") // cambiar puerto según auth-service
public interface AuthServiceClient {

    @GetMapping("/api/auth/user")
    UserResponseDTO getUserByUsername(@RequestParam String username);
}
