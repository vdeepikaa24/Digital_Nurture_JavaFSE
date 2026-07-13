# Exercise 1: User & Order Microservices Ecosystem

This repository contains a decoupled microservices architecture featuring independent data persistency and inter-service communication handled over HTTP via **Spring Cloud OpenFeign**. 

---

## 🏗️ Architecture Design Overview

The application is split into two standalone core business services:
* **User Service (`port: 8081`)**: Manages individual customer profile directories independently via `user_db`.
* **Order Service (`port: 8082`)**: Orchestrates order placements within `order_db` and consumes endpoints from the User Service synchronously via declarative REST clients to bundle transaction profiles.

---

## 🛠️ Technology Stack & Dependencies

* **Java 21** & **Spring Boot 3.5.16**
* **Spring Cloud OpenFeign** (Declarative REST Client routing)
* **Spring Data JPA** & **Hibernate ORM**
* **MySQL Database Connector**
* **Project Lombok** (Boilerplate reduction)

---

## 🚀 Environment Setup & Initialization

### 1. Database Creation
Execute the following statements on your local MySQL server instance to initialize the schemas:
```sql
CREATE DATABASE user_db;
CREATE DATABASE order_db;