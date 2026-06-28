package springcore_maven.exercise_2_implementing_dependency_injection.com.library.service;

import springcore_maven.exercise_2_implementing_dependency_injection.com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("Service: Executing library tasks.");
        bookRepository.getInfo();
    }
}