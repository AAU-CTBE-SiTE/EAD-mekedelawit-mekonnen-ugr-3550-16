# Student Management RESTful CRUD API 

A Spring Boot RESTful web application for managing Student records using Spring Web, Spring Data JPA, MySQL, and Lombok. This project follows a clean four-layer architecture (Model, Repository, Service, Controller) and operates directly on the JPA entity without DTOs, ResponseEntity wrappers, or custom exception handlers.

## Tech Stack
* **Language:** Java
* **Framework:** Spring Boot (spring-boot-starter-web, spring-boot-starter-data-jpa)
* **Database:** MySQL (mysql-connector-j)
* **Utilities:** Lombok (@Data, @NoArgsConstructor, @AllArgsConstructor)
* **Build Tool:** Maven

## Project Architecture
src/main/java/com/example/student_management/
├── controller/
│   └── StudentController.java    # REST endpoints (/api/students)
├── model/
│   └── Student.java              # JPA Entity mapped to the 'students' table
├── repository/
│   └── StudentRepository.java    # Spring Data JPA interface extending JpaRepository
└── service/
    └── StudentService.java       # Business logic and CRUD method delegation

## Entity Schema (Student)
Mapped to the students table in MySQL:
* id (Long): Primary key, auto-generated (GenerationType.IDENTITY)
* firstName (String): Required (nullable = false)
* lastName (String): Required (nullable = false)
* email (String): Required, unique (nullable = false, unique = true)
* department (String): Required (nullable = false)

## Setup & Installation
## 1. Prerequisites
* Java Development Kit (JDK 17+)
* Maven
* MySQL Server running locally on port 3306
* IntelliJ IDEA (or any Java IDE with Lombok annotation processing enabled)

## 2. Enable Lombok Annotation Processing (IntelliJ IDEA)
* Open Settings (Ctrl + Alt + S on Windows/Linux or Cmd + , on macOS).
* Navigate to Build, Execution, Deployment → Compiler → Annotation Processors.
* Check Enable annotation processing and click OK.

## 3. Configure MySQL in application.properties
Update src/main/resources/application.properties with your local MySQL credentials (avoid committing real passwords to public repositories):

spring.application.name=student-crud-api

spring.datasource.url=jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=<YOUR_MYSQL_USERNAME>
spring.datasource.password=<YOUR_MYSQL_PASSWORD>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## 4. Run the Application
Run the main @SpringBootApplication class from IntelliJ IDEA, or execute via Maven in your terminal:
mvn spring-boot:run
The server will start at http://localhost:8080.

## REST API Endpoints
Base URL: http://localhost:8080/api/students
| HTTP Method | Endpoint           | Description                | Request Body        | Response Behavior                                             |
|-------------|--------------------|----------------------------|---------------------|---------------------------------------------------------------|
| POST        | /api/students      | Create a new student       | JSON Student object | Returns created Student with generated id                     |
| GET         | /api/students      | Retrieve all students      | None                | Returns JSON array of all Student records                     |
| GET         | /api/students/{id} | Retrieve a student by ID   | None                | Returns Student if found, or null (empty body) if not found   |
| PUT         | /api/students/{id} | Update an existing student | JSON Student object | Updates fields while preserving id; returns null if not found |
| DELETE      | /api/students/{id} | Delete a student by ID     | None                | Removes record from database (void)                           |








