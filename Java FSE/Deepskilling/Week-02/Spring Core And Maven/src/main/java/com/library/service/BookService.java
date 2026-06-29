package com.library.service;
import com.library.repository.BookRepository;
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