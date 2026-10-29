package com.craft;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;

    // Parameterized constructor for Constructor Injection (Pages 11, 18)
    public Student(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("Student Parameterized Constructor Called");
    }

    public void getDetails() {
        System.out.println("Student Details " + this);
    }
}
