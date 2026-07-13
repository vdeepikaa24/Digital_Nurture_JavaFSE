package com.cognizant.inventory_service.controller;

import com.cognizant.inventory_service.entity.Inventory;
import com.cognizant.inventory_service.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping
    public Inventory updateStock(@RequestBody Inventory inventory) {
        Inventory existing = inventoryRepository.findByProductCode(inventory.getProductCode()).orElse(null);
        if (existing != null) {
            existing.setStockLevel(inventory.getStockLevel());
            return inventoryRepository.save(existing);
        }
        return inventoryRepository.save(inventory);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Inventory> getInventoryByCode(@PathVariable String productCode) {
        return inventoryRepository.findByProductCode(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}