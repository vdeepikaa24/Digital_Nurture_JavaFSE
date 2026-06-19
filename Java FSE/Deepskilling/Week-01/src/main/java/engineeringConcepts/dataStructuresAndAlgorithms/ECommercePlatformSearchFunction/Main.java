package engineeringConcepts.dataStructuresAndAlgorithms.ECommercePlatformSearchFunction;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Setup unsorted products for Linear Search
        Product[] products = {
            new Product("P103", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P105", "Gaming Headset", "Electronics"),
            new Product("P102", "Leather Wallet", "Accessories"),
            new Product("P104", "Running Shoes", "Footwear")
        };

        String searchId = "String"; // Target to search
        searchId = "P104";

        System.out.println("--- Linear Search Demonstration ---");
        Product resultLinear = SearchEngine.linearSearch(products, searchId);
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Not Found"));

        // 2. Sort array to prepare for Binary Search
        Arrays.sort(products); 

        System.out.println("\n--- Binary Search Demonstration ---");
        Product resultBinary = SearchEngine.binarySearch(products, searchId);
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Not Found"));
    }
}
