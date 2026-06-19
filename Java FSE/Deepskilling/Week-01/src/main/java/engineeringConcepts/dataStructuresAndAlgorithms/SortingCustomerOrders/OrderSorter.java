package engineeringConcepts.dataStructuresAndAlgorithms.SortingCustomerOrders;

public class OrderSorter {

    /**
     * 1. Bubble Sort Implementation
     * Sorts orders in descending order by totalPrice (high-value prioritized)
     */
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // To prioritize high-value orders, sort descending (smaller values bubble to the end)
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    // Swap elements
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped in the inner loop, array is already sorted
            if (!swapped) break;
        }
    }

    /**
     * 2. Quick Sort Implementation (Public interface method)
     */
    public static void quickSort(Order[] orders) {
        if (orders == null || orders.length == 0) return;
        executeQuickSort(orders, 0, orders.length - 1);
    }

    // Internal recursive method for Quick Sort
    private static void executeQuickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            
            // Recursively sort elements before and after partition
            executeQuickSort(orders, low, pivotIndex - 1);
            executeQuickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition logic selecting the last element as the pivot
    private static int partition(Order[] orders, int low, int high) {
        double pivotPrice = orders[high].getTotalPrice();
        int i = (low - 1); // Index of larger element for descending order

        for (int j = low; j < high; j++) {
            // Adjust condition for descending order (higher values move left)
            if (orders[j].getTotalPrice() >= pivotPrice) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap the pivot element with the correct sequential element
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}