package springcore_maven.exercise_2_implementing_dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcore_maven.exercise_2_implementing_dependency_injection.com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // Ensure applicationContext.xml is in src/main/resources
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.execute();
    }
}