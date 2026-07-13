package com.cognizant.product_service.controller;

import com.cognizant.product_service.entity.Product;
import com.cognizant.product_service.repository.ProductRepository;
import com.cognizant.product_service.dto.InventoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final RestClient.Builder restClientBuilder;

    public ProductController(ProductRepository productRepository, RestClient.Builder restClientBuilder) {
        this.productRepository = productRepository;
        this.restClientBuilder = restClientBuilder;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Map<String, Object>> getProductDetails(@PathVariable String productCode) {
        Product product = productRepository.findByProductCode(productCode).orElse(null);
        if (product == null) return ResponseEntity.notFound().build();

        InventoryDTO inventory = restClientBuilder.build()
                .get()
                .uri("http://inventory-service/api/inventory/" + productCode)
                .retrieve()
                .body(InventoryDTO.class);

        Map<String, Object> response = new HashMap<>();
        response.put("id", product.getId());
        response.put("productCode", product.getProductCode());
        response.put("name", product.getName());
        response.put("price", product.getPrice());
        response.put("stockLevel", inventory != null ? inventory.getStockLevel() : 0);

        return ResponseEntity.ok(response);
    }
}