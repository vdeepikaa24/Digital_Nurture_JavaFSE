package springcore_maven.exercise_1_configuring_a_basic_spring_application.com.library.service;

import springcore_maven.exercise_1_configuring_a_basic_spring_application.com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Use setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // THIS IS THE METHOD NAME: ensure it matches Main.java
    public void execute() {
        System.out.println("Service: Executing library tasks.");
        bookRepository.getInfo();
    }
}