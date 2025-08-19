package com.ordermanagement.orderservice.security;

import com.ordermanagement.orderservice.client.AuthServiceClient;
import com.ordermanagement.orderservice.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthServiceClient authServiceClient; // Cliente Feign al auth-service

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Llamada al auth-service para obtener datos del usuario
        UserResponseDTO userDTO = authServiceClient.getUserByUsername(username);

        if (userDTO == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Creamos UserDetails con username, password y roles (aquí simple, ROLE_USER)
        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword()) // ya viene encriptada
                .authorities(Collections.singletonList(() -> "ROLE_USER"))
                .build();
    }
}
