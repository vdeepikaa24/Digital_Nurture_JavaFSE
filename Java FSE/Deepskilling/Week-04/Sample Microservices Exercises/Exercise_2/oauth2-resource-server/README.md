# OAuth 2.0 Resource Server

This project is a **Spring Boot 3** implementation of an **OAuth 2.0 Resource Server**. It is designed to protect API endpoints by validating JSON Web Tokens (JWT) issued by an authorized Authorization Server.

## 🚀 Key Implementation Features
* **Modern Security:** Built using Spring Security 6+ and `SecurityFilterChain`, replacing the now-deprecated `WebSecurityConfigurerAdapter`.
* **Resource Server Pattern:** Configured to act as a secure gateway that mandates valid JWT authentication for all incoming requests.
* **Standards Compliance:** Uses the OAuth2 Resource Server DSL for clean and modular security configurations.

## 🛠 Tech Stack
* **Java 21**
* **Spring Boot 3.5.16**
* **Spring Security 6+**
* **OAuth2 Resource Server**

## 📦 Project Structure
```text
src/main/java/com/cognizant/oauth2_resource_server/
├── config/
│   └── ResourceServerConfig.java     # SecurityFilterChain for JWT validation
├── controller/
│   └── SecureController.java         # Protected API endpoint
└── Oauth2ResourceServerApplication.java