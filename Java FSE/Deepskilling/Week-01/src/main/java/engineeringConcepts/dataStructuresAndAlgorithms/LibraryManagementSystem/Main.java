package engineeringConcepts.dataStructuresAndAlgorithms.LibraryManagementSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Unsorted repository of book catalog listings
        Book[] libraryCatalog = {
            new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B001", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "1984", "George Orwell"),
            new Book("B002", "Moby Dick", "Herman Melville")
        };

        String searchTitle = "1984";

        // 1. Linear Search Run
        System.out.println("=== Testing Linear Search (Unsorted Data) ===");
        Book matchedLinear = LibrarySearchEngine.linearSearchByTitle(libraryCatalog, searchTitle);
        System.out.println("Found via Linear: " + (matchedLinear != null ? matchedLinear : "Not Found"));

        // 2. Sorting data explicitly for Binary Search compatibility
        System.out.println("\n... Sorting library catalog by title dynamically ...");
        Arrays.sort(libraryCatalog); 

        // 3. Binary Search Run
        System.out.println("\n=== Testing Binary Search (Sorted Data) ===");
        Book matchedBinary = LibrarySearchEngine.binarySearchByTitle(libraryCatalog, searchTitle);
        System.out.println("Found via Binary: " + (matchedBinary != null ? matchedBinary : "Not Found"));
    }
}