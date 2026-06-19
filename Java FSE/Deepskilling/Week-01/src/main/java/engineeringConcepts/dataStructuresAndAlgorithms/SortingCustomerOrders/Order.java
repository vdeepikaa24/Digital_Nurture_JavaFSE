package engineeringConcepts.dataStructuresAndAlgorithms.SortingCustomerOrders;

public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice; // <- Check that this variable name matches!

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // --- CRITICAL GETTER ---
    // Make sure this is public, spelled exactly like this, and returns a double
    public double getTotalPrice() { 
        return totalPrice; 
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }

    @Override
    public String toString() {
        return "Order{" + "id='" + orderId + "', price=$" + totalPrice + "}";
    }
}