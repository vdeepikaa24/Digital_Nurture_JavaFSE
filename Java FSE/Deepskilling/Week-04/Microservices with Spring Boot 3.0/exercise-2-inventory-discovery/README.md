# Inventory Management System with Service Discovery

An enterprise-grade, microservices-based architecture built with **Spring Boot 3.x**, implementing centralized external configuration management and dynamic service registration/discovery.

---

## 🏗️ Architecture & Component Overview

This ecosystem decouples configuration, discovery, and business logic into modular components:

* **Config Server (`port: 8888`)**: The central configuration provider running the `native` profile to serve environment variables from a local directory.
* **Eureka Discovery Server**: The foundational registry where microservices broadcast their network locations and metadata.
* **Product Service (`port: 8083`)**: Handles core product specifications and catalog logic, pulling external profiles to manage state in MySQL.
* **Inventory Service (`port: 8084`)**: Manages real-time stock levels and warehouse thresholds, pulling configurations centrally to connect to its distinct MySQL database.
* **Config Repo**: An externalized directory sitting at the workspace root containing individual service operational blueprints.

---

## 📂 Project Structure

```text
exercise-2-inventory-discovery/
├── config-repo/               # Root external configuration store
│   ├── inventory-service.properties
│   └── product-service.properties
├── config-server/             # Spring Cloud Config Server (Port 8888)
├── inventory-service/         # Inventory Microservice (Port 8084)
└── product-service/           # Product Microservice (Port 8083)