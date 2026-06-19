package engineeringConcepts.dataStructuresAndAlgorithms.ECommercePlatformSearchFunction;

import java.util.Arrays;

public class SearchEngine {

    /**
     * Linear Search Algorithm
     * Time Complexity: O(n)
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product != null && product.getProductId().equalsIgnoreCase(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search Algorithm
     * Time Complexity: O(log n)
     * Note: Expects a pre-sorted array!
     */
    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductId().compareToIgnoreCase(targetId);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Small local driver method to test execution
    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Wireless Mouse", "Electronics"),
            new Product("P001", "Mechanical Keyboard", "Electronics"),
            new Product("P004", "Gaming Headset", "Electronics"),
            new Product("P002", "Leather Wallet", "Accessories")
        };

        String searchId = "P004";

        System.out.println("=== Running Linear Search ===");
        Product match1 = linearSearch(products, searchId);
        System.out.println("Found via Linear: " + match1);

        System.out.println("\n=== Sorting Array for Binary Search ===");
        Arrays.sort(products); 

        System.out.println("\n=== Running Binary Search ===");
        Product match2 = binarySearch(products, searchId);
        System.out.println("Found via Binary: " + match2);
    }
}