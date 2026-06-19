package engineeringConcepts.dataStructuresAndAlgorithms.SortingCustomerOrders;

public class Main {
    public static void main(String[] args) {
        // Mocking an unsorted array of baseline e-commerce orders
        Order[] ordersForBubble = {
            new Order("O101", "Alice", 250.50),
            new Order("O102", "Bob", 1200.00),
            new Order("O103", "Charlie", 75.25),
            new Order("O104", "David", 430.10),
            new Order("O105", "Emma", 890.95)
        };

        // Clone the array to keep a fair benchmark setup for Quick Sort
        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("=== Original Unsorted Orders ===");
        printOrders(ordersForBubble);

        // 1. Run Bubble Sort
        System.out.println("\n=== Executing Bubble Sort (Descending) ===");
        OrderSorter.bubbleSort(ordersForBubble);
        printOrders(ordersForBubble);

        // 2. Run Quick Sort
        System.out.println("\n=== Executing Quick Sort (Descending) ===");
        OrderSorter.quickSort(ordersForQuick);
        printOrders(ordersForQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}