# Edge Service Routing and Filtering (Exercise 1)

This project is part of a Microservices learning path using **Spring Boot 4.1.0** and **Spring Cloud**. It implements an Edge Service (API Gateway) to manage traffic and monitor requests in a microservices architecture.

## Project Overview
The goal of this exercise is to implement an API Gateway that acts as a central entry point. It performs two key tasks:
1. **Routing:** Routes specific traffic from the gateway to a target destination.
2. **Filtering:** Logs the URI of every incoming request for monitoring and debugging purposes.

## Technical Stack
- **Framework:** Spring Boot 4.1.0
- **Library:** Spring Cloud Gateway (WebFlux)
- **Language:** Java 25

## Implementation Details
- **Routing:** Configured in `application.properties` to route traffic from `/example/**` to `http://example.org`.
- **Filtering:** A custom `LoggingFilter` implemented as a `GlobalFilter` to intercept all requests and print the target URI to the console.

## How to Run
1. Ensure your environment is set up with **JDK 25**.
2. Open the project in your IDE (VS Code or IntelliJ).
3. Open a terminal in the project root directory.
4. Run the following command to start the application:
   ```bash
   ./mvnw spring-boot:run