package engineeringConcepts.dataStructuresAndAlgorithms.LibraryManagementSystem;

public class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getBookId() { 
        return bookId; 
    }

    public String getTitle() { 
        return title;
     }

    public String getAuthor() {
         return author;
         }

    // Crucial for Binary Search: Defaults sorting naturally by book title alphabetically
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}