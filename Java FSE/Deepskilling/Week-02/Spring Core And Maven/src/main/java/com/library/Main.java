package com.library;
import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean from the Spring container
        BookService service = context.getBean("bookService", BookService.class);

        // Call the method
        service.executeLibraryTasks();

        context.close();
    }
}