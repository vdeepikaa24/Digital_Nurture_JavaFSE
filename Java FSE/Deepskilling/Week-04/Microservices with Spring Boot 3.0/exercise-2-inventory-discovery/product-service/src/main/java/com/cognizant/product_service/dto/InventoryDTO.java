package com.cognizant.product_service.dto;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private String productCode;
    private Integer stockLevel;
}