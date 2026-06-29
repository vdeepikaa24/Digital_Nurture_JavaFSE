package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // 1. Add this Empty Constructor (required for setter injection)
    public BookService() {
        System.out.println("BookService: Default constructor called");
    }

    // 2. Your Constructor for Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Initialized via Constructor Injection");
    }

    // 3. Your Setter for Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Initialized via Setter Injection");
    }

    public void executeLibraryTasks() {
        System.out.println("Service: Executing library tasks.");
        bookRepository.doRepositoryWork();
    }
}