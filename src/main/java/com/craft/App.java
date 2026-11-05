package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize Spring Container using Java Configuration class instead of XML
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Student bean from the container
        Student student = context.getBean(Student.class);

        // Display results and subject details
        System.out.println(student);
        student.getDetails();
    }
}
