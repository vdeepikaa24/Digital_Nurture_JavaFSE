package com.cognizant.order_service.dto;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long id;
    private String productCode;
    private Integer quantity;
    private Double price;
    private UserDTO user;
}