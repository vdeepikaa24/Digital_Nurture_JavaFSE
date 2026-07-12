# OAuth2 Client Exercise

This project is a modern implementation of a **Spring Boot 3** application acting as an **OAuth 2.1/OIDC Client**. It demonstrates how to integrate with an identity provider (Google) to handle centralized authentication.

## 🚀 Key Improvements & Modernization
The original exercise provided was based on deprecated Spring Security 5 patterns. This implementation has been upgraded to follow **Spring Boot 3 and Spring Security 6+ standards**:

* **Security Configuration:** Migrated from the deprecated `WebSecurityConfigurerAdapter` to the modern `SecurityFilterChain` bean approach.
* **Architecture:** Implemented a clean, layered folder structure (`config`, `controller`) for better maintainability and scalability.
* **Best Practices:** Adhered to the Principle of Least Privilege and proper dependency injection for security configurations.

## 🛠 Tech Stack
* **Java 21**
* **Spring Boot 3.5.16**
* **Spring Security 6+**
* **OAuth2 Client**

## 📦 Project Structure
```text
src/main/java/com/cognizant/oauth2_client_exercise/
├── config/
│   └── SecurityConfig.java       # Modern SecurityFilterChain configuration
├── controller/
│   └── UserController.java       # Secure endpoint returning Principal details
└── Oauth2ClientExerciseApplication.java # Application entry point