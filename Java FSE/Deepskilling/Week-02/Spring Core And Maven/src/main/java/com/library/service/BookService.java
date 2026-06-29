package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // The setter method Spring uses for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void executeLibraryTasks() {
        System.out.println("Service: Executing library tasks.");
        bookRepository.doRepositoryWork();
    }
}