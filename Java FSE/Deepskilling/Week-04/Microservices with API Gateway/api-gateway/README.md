# API Gateway

The API Gateway serves as the central routing proxy and service discovery client for the microservices architecture.

- **Port:** 9090
- **Service ID:** `api-gateway`
- **Routing:** - `account-service` -> `/account-service/**`
  - `loan-service`    -> `/loan-service/**`

---
*Note: For full architecture startup instructions, dependency management, and environment setup, view the master [README.md](../README.md) file in the parent project directory.*