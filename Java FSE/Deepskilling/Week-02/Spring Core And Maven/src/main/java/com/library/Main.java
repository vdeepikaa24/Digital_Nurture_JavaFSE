package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Verify Constructor Injection
        System.out.println("--- Testing Constructor Injection ---");
        BookService serviceC = context.getBean("bookServiceConstructor", BookService.class);
        serviceC.executeLibraryTasks();

        // Verify Setter Injection
        System.out.println("\n--- Testing Setter Injection ---");
        BookService serviceS = context.getBean("bookServiceSetter", BookService.class);
        serviceS.executeLibraryTasks();

        context.close();
    }
}