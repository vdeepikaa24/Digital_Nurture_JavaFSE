# Reactive API Gateway (Spring Cloud Gateway)

An enterprise-ready, reactive API Gateway built with **Spring Boot 3.4.3** and **Spring Cloud 2024.0.0 (Moxton)**. It acts as a single entry point for microservices, providing unified request routing, path rewriting, token/IP-based rate limiting, and local in-memory response caching.

---

## 🚀 Features

* **Intelligent Routing**: Dynamic route forwarding to downstream microservices (`Customer Service` and `Billing Service`).
* **Path Rewriting**: Automatically strips gateway-specific API prefixes before sending requests to target microservices.
* **Distributed Rate Limiting**: Uses **Redis** alongside a Token Bucket algorithm to throttle incoming requests by client IP addresses.
* **High-Performance Caching**: Employs **Caffeine Cache** locally at the gateway layer to eliminate redundant downstream microservice calls for identical requests.

---

## 🛠️ Architecture & Route Layout

The gateway listens on port `8080` and routes incoming traffic based on the following configurations:

| Incoming Path Rule | Downstream Target URL | Rewritten Downstream Path | Rate Limit (Replenish / Burst) | Cache Duration |
| :--- | :--- | :--- | :--- | :--- |
| `/api/v1/customers/**` | `http://localhost:8081` | `/**` | 10 / 20 req/sec | 3 Minutes |
| `/api/v1/billing/**` | `http://localhost:8082` | `/**` | 5 / 10 req/sec | 3 Minutes |

---

## 💻 Tech Stack & Dependencies

* **Java 21**
* **Spring Boot 3.4.3**
* **Spring Cloud Gateway** (Reactive)
* **Spring Data Reactive Redis** (For Rate Limiting)
* **Caffeine Cache** (For Local Response Caching)

---

## ⚙️ Prerequisites

Before launching the gateway, ensure you have the following running:
1. **Java Development Kit (JDK 21 or higher)**
2. **Apache Maven 3.9+**
3. **Redis Server** running locally on port `6379`. (If using Docker, you can run: `docker run --name gateway-redis -p 6379:6379 -d redis`)

---

## 🛠️ Execution Guide

### 1. Compile and Build
Clean the workspace and compile the project to ensure all reactive dependencies resolve:
```bash
mvn clean compile