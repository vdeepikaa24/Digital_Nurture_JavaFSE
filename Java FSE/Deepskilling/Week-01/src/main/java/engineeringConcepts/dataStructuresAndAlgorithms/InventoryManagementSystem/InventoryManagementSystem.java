package engineeringConcepts.dataStructuresAndAlgorithms.InventoryManagementSystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Create mock products
        Product p1 = new Product("P001", "Laptop", 10, 899.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Wireless Headphones", 50, 79.99);

        // Test Add
        System.out.println("--- Testing Add ---");
        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        manager.displayInventory();

        // Test Update
        System.out.println("\n--- Testing Update ---");
        manager.updateProduct("P002", 20, 450.00); // lower price & stock
        manager.displayInventory();

        // Test Delete
        System.out.println("\n--- Testing Delete ---");
        manager.deleteProduct("P001");
        manager.displayInventory();
    }
}
