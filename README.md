# Student Management App — Spring Boot REST API

A beginner-friendly Spring Boot project demonstrating how to build RESTful CRUD APIs using a Controller-Service-Repository architecture with in-memory data storage.

This project was created to understand the basics of Spring Boot, API handling, dependency injection, and structuring backend services without using a database.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [API Endpoints](#api-endpoints)  
- [How to Run](#how-to-run)  
- [Future Improvements](#future-improvements)  
- [Author](#author)

---

## Features

The application currently supports:

### Students
- Add a student  
- Get a student by ID using Query Parameter  
- Get a student by ID using Path Variable  
- Get all students  

### Teachers
- Add a teacher  
- Get teacher details by name  
- Delete teacher by name  

### Student–Teacher Mapping
- Assign student to teacher
- Get students for a given teacher

---

## Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **Build Tool:** Maven  
- **Server:** Embedded Tomcat  
- **Data Storage:** In-memory HashMaps (no database)

---

## Project Structure

Student-Management-App-SpringBoot/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.example.Student.management.app/
│ │ │ ├── StudentManagementAppApplication.java
│ │ │ ├── StudentController.java
│ │ │ ├── StudentService.java
│ │ │ ├── StudentRepository.java
│ │ │ ├── Student.java
│ │ │ └── Teacher.java
│ │ └── resources/
│ │ └── application.properties
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml



---

## API Endpoints

### Students

| Method | URI                          | Description                          |
|--------|------------------------------|--------------------------------------|
| POST   | `/student/add`               | Add a new student                   |
| GET    | `/student/get-student?id=`   | Get student details by ID (query)   |
| GET    | `/student/get-student-by-path/{id}` | Get student by ID (path)   |

### Teachers

| Method | URI                                     | Description                         |
|--------|-----------------------------------------|-------------------------------------|
| POST   | `/student/add-teacher`                  | Add a teacher                      |
| GET    | `/student/get-teacher-by-name/{name}`    | Get teacher by name                |
| DELETE | `/student/delete-teacher-by-name?name=` | Delete teacher by name             |

### Student-Teacher Mapping

| Method | URI                                                | Description                      |
|--------|----------------------------------------------------|----------------------------------|
| PUT    | `/student/add-student-teacher-pair?studentId=&teacherId=` | Map a student to a teacher |
| GET    | `/student/get-students-by-teacher/{teacherId}`       | Get students by teacher ID     |

---

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/Waseeyurrahman/Student-management-app-SpringBoot

2.Open the project in IntelliJ IDEA or any Java IDE.

3.Build the project with Maven:
     mvn clean install

4.Run the application:
   mvn spring-boot:run

5.Use Postman, Insomnia, or browser to test the APIs at:
   http://localhost:8080    
