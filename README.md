En el desarrollo de microservicios para el proyecto Order Management System, apliqué distintos patrones de diseño de software para lograr una arquitectura limpia, escalable y mantenible:

**Patrones de diseño aplicados en microservicios con Spring Boot**

- Singleton
Los beans de Spring (@Service, @Repository, @Controller) se crean como instancias únicas, garantizando eficiencia en la gestión de recursos.

- Repository Pattern
Implementado con Spring Data JPA (OrderRepository, ProductRepository). Aísla la lógica de persistencia de la lógica de negocio, facilitando pruebas unitarias y cambios de base de datos sin afectar otras capas.

- DTO (Data Transfer Object)
Uso de clases DTO (OrderRequestDTO, OrderResponseDTO, etc.) para transportar datos entre capas sin exponer directamente las entidades. Esto asegura encapsulamiento y una API clara y estable.

- Facade
Los controladores (OrderController, ProductController) funcionan como fachada entre el cliente (frontend/Postman) y la lógica interna, exponiendo una interfaz simple y desacoplada.

- Proxy
Con Feign Clients (AuthServiceClient, ProductClient), cada microservicio se comunica con otros de forma transparente, como si fueran servicios locales, aplicando el patrón Proxy.

- Strategy
En el módulo de seguridad (JwtUtil, JwtFilter), la validación de tokens JWT se implementa como estrategia, lo que permite cambiar algoritmos o reglas de autenticación sin impactar el resto del sistema.

**Este enfoque permitió construir microservicios seguros, modulares y fáciles de mantener, aplicando prácticas recomendadas de arquitectura de software y patrones de diseño en Java.**
