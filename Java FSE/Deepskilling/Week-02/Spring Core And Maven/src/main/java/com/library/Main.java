package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve by class type (cleaner and safer)
        BookService service = context.getBean(BookService.class);

        // Execute task
        service.executeLibraryTasks();

        context.close();
    }
}