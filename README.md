**Orderservice – gestión de pedidos**

Función principal: crear y consultar pedidos de productos.

- Entradas: requests del frontend para:

Crear un pedido con items (requiere JWT).

Consultar pedidos propios (requiere JWT).

- Salidas: JSON con detalles del pedido (OrderResponseDTO) o error si el token es inválido.

Cómo usa authservice:

Valida JWT de usuario.

Opcional: usa AuthServiceClient (Feign) para traer información de usuario (ej: email, nombre completo) si necesita mostrarla en los pedidos.

🔗 Resumen de la interacción entre microservicios

Frontend → authservice

Registro o login → obtiene JWT.

Frontend → productservice / orderservice

Envia JWT en Authorization.

Filtros JWT verifican que el token sea válido.

Endpoints públicos (GET) no requieren token.

orderservice → authservice

Opcionalmente, obtiene info de usuario mediante FeignClient.


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
