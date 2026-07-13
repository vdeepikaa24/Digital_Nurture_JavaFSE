package com.cognizant.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.order_service.client.UserClient;
import com.cognizant.order_service.dto.OrderResponseDTO;
import com.cognizant.order_service.dto.UserDTO;
import com.cognizant.order_service.entity.Order;
import com.cognizant.order_service.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            UserDTO user = userClient.getUserById(order.getUserId());
            if (user == null) {
                return ResponseEntity.badRequest().body("User validation failed: User does not exist.");
            }
            Order savedOrder = orderRepository.save(order);
            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User service validation failed: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        UserDTO user = userClient.getUserById(order.getUserId());

        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setProductCode(order.getProductCode());
        response.setQuantity(order.getQuantity());
        response.setPrice(order.getPrice());
        response.setUser(user);

        return ResponseEntity.ok(response);
    }
}