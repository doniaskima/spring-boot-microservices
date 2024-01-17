# Spring Boot Project Setup Mini-Project

## Introduction
Welcome to the Spring Boot Project Setup Mini-Project. This project is designed to introduce you to the challenges and steps involved in setting up a new Spring Boot project, including installing dependencies and developing a basic application.

## Objectives
- Understand the structure of a Spring Boot project.
- Learn how to set up a Spring Boot project from scratch.
- Explore how to add and manage dependencies.
- Develop a basic Spring Boot application.

## Getting Started
### Prerequisites
- JDK 1.8 or later
- Maven 3.2+

### Setting Up the Project
1. **Create a Spring Boot Project:**
   - Use [Spring Initializr](https://start.spring.io/) to generate your project structure.
   - Choose your preferred dependencies and download the project.

2. **Import the Project:**
   - Open your IDE (e.g., IntelliJ IDEA, Eclipse) and import the project as a Maven project.

3. **Explore the Project Structure:**
   - Familiarize yourself with the standard Spring Boot project layout.

### Installing Dependencies
- Add any additional dependencies you need in the `pom.xml` file.
- Use Maven commands to install and manage these dependencies.

## Development
- Start by editing the `Application.java` file to create your first simple REST endpoint.
- Explore how to configure your application using `application.properties` or `application.yml`.

## Running the Application
- Run the application from your IDE or use the command line: `mvn spring-boot:run`.
- Access the REST endpoints you have created.

## Conclusion
This mini-project is a hands-on guide to setting up and developing a Spring Boot application. Through this exercise, you will gain a better understanding of the Spring Boot framework and its capabilities.

## Resources
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Framework Guides](https://spring.io/guides)

# PART1: Building Services

![Architecture](addons/github_assets/architecture.PNG)

In this section, we'll explore the fundamental concepts and annotations used for building services with Spring Boot. We'll discuss key annotations, project setup using Maven, and an overview of building Spring Boot applications.

## What I've Learned

### Spring Boot Application Setup
1. `@SpringBootApplication`: Marks the main class of a Spring Boot application and enables auto-configuration and component scanning.
2. Project setup using [https://start.spring.io/](https://start.spring.io/): This web-based tool helps create a Maven project with the necessary dependencies and configurations for Spring Boot applications.

# What You Can Learn from Building Services

## 1. Microservices Architecture
   - Understand the principles of designing applications as a set of small, independent, and loosely coupled services.

## 2. Spring Boot
   - Learn how to use Spring Boot, a popular framework for building Java-based microservices, and its features for rapid development.

## 3. RESTful API Development
   - Gain expertise in creating RESTful APIs that expose your service's functionalities to clients.

## 4. Database Interactions
   - Learn how to interact with databases using Spring Data JPA or other persistence technologies to store and retrieve data.

## 5. Dependency Injection
   - Understand how to manage dependencies and perform dependency injection in Spring Boot applications.

## 6. Service Configuration
   - Learn how to configure your services using properties, YAML files, environment variables, and configuration classes.


### Annotation Essentials
```java
3. @RestController: Indicates that a class is a RESTful controller, handling HTTP requests and returning responses.
4. @RequestMapping: Maps HTTP requests to controller methods and specifies the request path.
5. @Autowired: Injects dependencies, such as beans or services, into a class or constructor.
6. @Service: Indicates that a class is a service component, typically containing business logic.
7. @Repository: Marks a class as a repository, often used for database operations with Spring Data.
8. @Component: Marks a class as a Spring component, allowing it to be automatically discovered and managed by the Spring container.
9. @Configuration: Identifies a class as a configuration class for defining beans and configurations.
10. @Value: Injects values from properties files or configuration into fields or method parameters.
11. @Profile: Specifies which profiles should activate a particular component or configuration.
12. @EnableAutoConfiguration: Enables Spring Boot's automatic configuration based on classpath dependencies.
13. @Entity: Declares a class as a JPA entity, representing a database table.
14. @Table: Defines the database table associated with a JPA entity.
15. @Id: Marks a field as the primary key in a JPA entity.
16. @Column: Maps a field to a database column in a JPA entity.
17. @OneToMany and @ManyToOne: Define relationships between JPA entities for one-to-many and many-to-one associations.
18. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping: Specify HTTP request methods in controller methods.
19. @ExceptionHandler: Handles exceptions globally in a Spring MVC application.
20. @Transactional: Specifies transactional behavior for methods in a service or repository.
21. @Valid: Indicates that a parameter should be validated using Bean Validation (JSR-303).
22. @Bean: Marks a method as a Spring bean factory, allowing custom bean creation and configuration within a Spring application context.

# Project Structure and Configuration

## `pom.xml` - The Heart of Your Project

The `pom.xml` file, also known as the Project Object Model, is a critical component of Maven-based Java projects. It serves several essential roles in managing your project:

1. **Project Configuration**: The `pom.xml` file defines key project information, such as its name, version, and description. It ensures clarity and uniqueness in project identification.

2. **Project Dependencies**: You can list external libraries and components that your project relies on within the `pom.xml`. Maven then automatically manages and downloads these dependencies, simplifying project setup and ensuring consistency across development environments.

3. **Build Lifecycle Configuration**: The `pom.xml` specifies how your project is built and packaged. It outlines build phases (e.g., compilation, testing, packaging) and utilizes plugins with their configurations to execute these tasks. This automation streamlines the development process.

In summary, the `pom.xml` file is fundamental to your Maven-based project. It streamlines project configuration, simplifies dependency management, and automates the build process, making it a crucial tool for Java developers.
