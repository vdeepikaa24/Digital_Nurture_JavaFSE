package springcore_maven.exercise_1_configuring_a_basic_spring_application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcore_maven.exercise_1_configuring_a_basic_spring_application.com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // Load the context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean by the ID defined in applicationContext.xml
        BookService bookService = (BookService) context.getBean("bookService");

        // Verify it works
        System.out.println("Spring Context Loaded Successfully!");
        bookService.execute(); // Make sure this method exists in your BookService class
    }
}