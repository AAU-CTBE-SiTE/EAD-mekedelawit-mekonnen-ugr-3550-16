package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class App {
    // Factory is static and class-wide so it is only initialized once
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // 1. CREATE
    public static void createStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // 2. READ
    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.close();
        return student;
    }

    // 3. UPDATE
    public static void updateStudentName(String newName, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setName(newName);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // 4. DELETE
    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void main(String[] args) {
        // Add sample students to have sufficient data for querying
        Student s1 = new Student();
        s1.setName("Firaol Mengistu");
        s1.setTech("Java");
        createStudent(s1);

        Student s2 = new Student();
        s2.setName("Alex Ferguson");
        s2.setTech("C++");
        createStudent(s2);

        System.out.println("\n--- JPQL: All Students ---");
        List<Student> all = getAllStudents();
        all.forEach(System.out::println);

        System.out.println("\n--- JPQL: Filter by Tech (Java) ---");
        List<Student> javaStudents = getStudentsByTech("Java");
        javaStudents.forEach(System.out::println);

        System.out.println("\n--- JPQL: Total Count ---");
        System.out.println("Total student count: " + countAllStudents());

        // Close factory at application shutdown
        emf.close();
    }
    // 1. Select All Students (TypedQuery)
    public static List<Student> getAllStudents() {
        EntityManager em = getEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();
        em.close();
        return students;
    }

    // 2. Select Students by Technology (Named Parameter :tech)
    public static List<Student> getStudentsByTech(String tech) {
        EntityManager em = getEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.tech = :tech", Student.class);
        query.setParameter("tech", tech);
        List<Student> students = query.getResultList();
        em.close();
        return students;
    }

    // 3. Count Total Students (Aggregate Query)
    public static long countAllStudents() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s");
        long count = (long) query.getSingleResult();
        em.close();
        return count;
    }
}


