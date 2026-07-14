# Resilient Payment Service (Resilience4j Circuit Breaker)

A resilient microservice built with **Spring Boot 3.4.3** and **Resilience4j**. It simulates interacting with a slow third-party API and handles potential timeouts or failures gracefully using a Circuit Breaker pattern with configured fallback logic.

---

## 🚀 Features

* **Fault Isolation**: Uses Resilience4j's Circuit Breaker to intercept network requests and protect resources.
* **Smart Fallback**: Redirects traffic to a local backup execution flow if the third-party service is offline or responding slowly.
* **Event Logging**: Logs and reports transition/failure details directly in the system logs.
* **Real-time Monitoring**: Exposes operational states and health statistics using **Spring Boot Actuator**.

---

## ⚙️ Circuit Breaker Configurations

The circuit breaker behavior is configured in the application’s configuration files under the instance name `thirdPartyPaymentApi`:

| Setting | Value | Description |
| :--- | :--- | :--- |
| **Sliding Window Type** | `COUNT_BASED` | Metrics are calculated over a sliding number of requests. |
| **Sliding Window Size** | `5` | The circuit breaker evaluates the last 5 calls. |
| **Failure Rate Threshold** | `50%` | Trips to `OPEN` if 50% or more calls fail. |
| **Slow Call Rate Threshold**| `50%` | Trips to `OPEN` if 50% or more calls are slow. |
| **Slow Call Duration** | `2s` | Any API call taking longer than 2 seconds is flagged as slow. |
| **Wait Duration (Open State)**| `15s` | Stays open for 15 seconds before transitioning to test state. |
| **Half-Open Trial Size** | `2` | Runs 2 trial requests in `HALF_OPEN` state to check service recovery. |

---

## 💻 Tech Stack

* **Java 21**
* **Spring Boot 3.4.3**
* **Spring Boot Actuator**
* **Spring AOP**
* **Resilience4j**

---

## 🛠️ Execution & Testing Guide

### 1. Run the Application
Open your terminal in the root of the project and execute:
```bash
mvn clean compile
mvn spring-boot:run