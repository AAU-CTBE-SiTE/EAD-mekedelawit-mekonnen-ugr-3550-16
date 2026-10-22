# JPA & Hibernate 
This project demonstrates database persistence using Jakarta Persistence API (JPA) and Hibernate ORM configured with a MySQL database. It covers project dependency setup, entity lifecycle management, basic CRUD operations, and JPQL (Java Persistence Query Language) queries.

## Prerequisites 
* **Java:** JDK 17+ (JDK 23 used)
* **Build Tool:** Apache Maven
* **ORM / JPA Provider:** Hibernate ORM 6.4.4.Final / Jakarta Persistence API 3.1.0
* **Database:** MySQL Server 8.0+ / MySQL Workbench
* **Driver:** MySQL Connector/J 8.3.0
* **Utilities:** Project Lombok 1.18.30

### Database Setup
Create the lab database schema using MySQL Workbench or the MySQL command line client:
```sql
CREATE DATABASE jpadb1;
