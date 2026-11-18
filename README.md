# Actor Management System - MySQL CRUD API

A robust Spring Boot RESTful web application implementing full CRUD (Create, Read, Update, Delete) operations with a MySQL database using Spring Data JPA and the standard Repository-Service-Controller architecture.

## Tech Stack
* **Java:** 17
* **Framework:** Spring Boot
* **Persistence:** Spring Data JPA, Hibernate
* **Database:** MySQL (Connector/J)
* **Build Tool:** Maven

## Architecture & Design Pattern
The application follows a decoupled, layered architecture:
1. **Model Layer (`Actor.java`)**: JPA Entity mapped to the `actors` table.
2. **Repository Layer (`ActorRepository.java`)**: Extends `JpaRepository` to handle automated database interactions.
3. **Service Layer (`ActorService.java`)**: Encapsulates core business logic.
4. **Controller Layer (`ActorController.java`)**: Exposes RESTful endpoints for client consumption.
