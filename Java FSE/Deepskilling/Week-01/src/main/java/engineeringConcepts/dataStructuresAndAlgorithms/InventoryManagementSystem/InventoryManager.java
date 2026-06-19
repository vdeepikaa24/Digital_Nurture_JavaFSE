package engineeringConcepts.dataStructuresAndAlgorithms.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // Using HashMap with productId as Key for O(1) lookups
    private Map<String, Product> inventory;

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    // 1. Add Product
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists. Use update instead.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product.getProductName());
    }

    // 2. Update Product
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated ID " + productId + " successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // 3. Delete Product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removed = inventory.remove(productId);
            System.out.println("Removed: " + removed.getProductName());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Display Inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
