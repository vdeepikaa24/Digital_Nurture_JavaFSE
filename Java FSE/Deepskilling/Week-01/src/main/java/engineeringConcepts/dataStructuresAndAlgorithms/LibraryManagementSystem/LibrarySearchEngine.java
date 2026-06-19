package engineeringConcepts.dataStructuresAndAlgorithms.LibraryManagementSystem;

public class LibrarySearchEngine {

    /**
     * 1. Linear Search Algorithm
     * Works on any array (sorted or unsorted).
     * Time Complexity: O(n)
     */
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book; // Book found
            }
        }
        return null; // Book not found
    }

    /**
     * 2. Binary Search Algorithm
     * Mandates that the incoming array must be pre-sorted alphabetically by title!
     * Time Complexity: O(log n)
     */
    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid]; // Match found
            } else if (comparison < 0) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Book not found
    }
}