package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.craft")
public class AppConfig {

    // Defining individual Subject beans to be collected into a List
    @Bean
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Maths 101");
        return subject;
    }

    @Bean
    public Subject javaSubject() {
        Subject subject = new Subject();
        subject.setSubjectName("Java EE");
        return subject;
    }
}
