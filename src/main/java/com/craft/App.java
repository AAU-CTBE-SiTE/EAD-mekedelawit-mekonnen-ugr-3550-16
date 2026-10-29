package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize Spring Container using ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");

        // Retrieve the Student bean from the container
        Student student = context.getBean("student", Student.class);

        // Display results
        System.out.println(student);
    }
}
