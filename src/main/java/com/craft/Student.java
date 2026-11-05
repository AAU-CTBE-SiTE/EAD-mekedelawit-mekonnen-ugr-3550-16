package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@Component
public class Student {
    private int id = 101;
    private String name = "John Doe";
    private int age = 20;

    private Address address;
    private List<Subject> subjects;

    // Constructor Dependency Injection with @Autowired
    @Autowired
    public Student(Address address, List<Subject> subjects) {
        this.address = address;
        this.subjects = subjects;
        System.out.println("Student Parameterized Constructor Called via DI");
    }

    public void getDetails() {
        System.out.println("Student Name: " + this.getName());
        int index = 1;
        for (Subject subject : subjects) {
            System.out.println("Subject " + index + ": " + subject.getSubjectName());
            index++;
        }
    }
}
