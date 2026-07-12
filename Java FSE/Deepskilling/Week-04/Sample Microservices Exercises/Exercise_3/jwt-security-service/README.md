# Custom JWT Security Service

This project is a **Spring Boot 3** implementation demonstrating how to build a custom **JSON Web Token (JWT)** provider and authentication filter from scratch. It enables stateless, secure communication between client applications and APIs using custom token signing and verification.

## 🚀 Key Implementation Features
* **Modern Security Standards:** Configured using Spring Security 6+ components via a stateless `SecurityFilterChain` bean, entirely removing legacy `WebSecurityConfigurerAdapter` dependencies.
* **Modern JWT Engineering:** Implements the latest **JJWT 0.12.5** syntax, leveraging secure, cryptographic `SecretKey` generation (`Keys.hmacShaKeyFor`) rather than outdated plain-string signature hashing algorithms.
* **Stateless Filter Chain:** Utilizes a custom `OncePerRequestFilter` to extract incoming `Bearer` tokens, authenticate signatures, and programmatically establish the application's `SecurityContext`.

## 🛠 Tech Stack
* **Java 21**
* **Spring Boot 4.1.0**
* **Spring Security 6+**
* **JJWT (Java JWT) 0.12.5**

## 📦 Project Structure
```text
src/main/java/com/cognizant/jwt_security_service/
├── config/
│   ├── JwtConfig.java               # Loads configuration properties
│   └── SecurityConfig.java          # Configures stateless filter & endpoints
├── security/
│   ├── JwtTokenFilter.java          # Custom filter for extracting/validating Bearer tokens
│   └── JwtTokenProvider.java        # Core token utility (generation & signature parsing)
├── controller/
│   └── AuthController.java          # Exposes public login and protected endpoints
└── Oauth2ResourceServerApplication.java