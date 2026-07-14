# Microservices with API Gateway - Learning Project

A comprehensive microservices architecture demonstrating Spring Cloud, Eureka Discovery, and API Gateway patterns using Spring Boot 3.4.2 with Java 25.

## Project Overview

This project implements a bank-like microservices system with 5 independent Spring Boot services working together through a centralized API Gateway:

- **Account Service** - Handles account operations (Port: 8080)
- **Loan Service** - Handles loan operations (Port: 8081)
- **Greet Service** - Simple test microservice (Port: 8080/8082)
- **Eureka Discovery Server** - Centralized service registry (Port: 8761)
- **API Gateway** - Central entry point with request routing & logging (Port: 9090)

## Architecture Diagram

```
┌──────────────┐
│   Browser    │
└──────┬───────┘
       │ (Request)
       ▼
┌─────────────────────────────────────┐
│  API Gateway (Port: 9090)           │
│  - Route to microservices           │
│  - Request logging via Global Filter│
└──────┬──────────────────────────────┘
       │
   ┌───┼─────────────────────┐
   │   │                     │
   ▼   ▼                     ▼
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│ Account      │  │ Loan         │  │ Greet        │
│ Service      │  │ Service      │  │ Service      │
│ Port: 8080   │  │ Port: 8081   │  │ Port: 8082   │
└──────┬───────┘  └──────┬───────┘  └──────┬───────┘
       │                 │                 │
       └─────────────────┼─────────────────┘
                         │
                         ▼
            ┌──────────────────────────┐
            │  Eureka Discovery Server │
            │  (Port: 8761)            │
            │  - Service Registry      │
            │  - Health Monitoring     │
            └──────────────────────────┘
```

## Technology Stack

- **Java**: 25 (OpenJDK)
- **Spring Boot**: 3.4.2
- **Spring Cloud**: 2024.0.0
- **Build Tool**: Maven 3.3+
- **Eureka**: Spring Cloud Netflix Eureka
- **API Gateway**: Spring Cloud Gateway

## Prerequisites

- Java 17+ (tested with Java 25)
- Maven 3.8+
- Spring Boot 3.4.2
- Git (optional)

## Project Setup

### 1. Clone/Download Project
```bash
# Navigate to your project directory
cd Digital-Nurture-JavaFSE/Java FSE/Deepskilling/Week-04
```

### 2. Folder Structure
```
Microservices with API Gateway/
├── account/
├── loan/
├── eureka-discovery-server/
├── greet-service/
├── api-gateway/
└── README.md (this file)
```

### 3. Build All Services
```bash
# Build each service in separate terminals
cd account && mvn clean install
cd loan && mvn clean install
cd eureka-discovery-server && mvn clean install
cd greet-service && mvn clean install
cd api-gateway && mvn clean install
```

## Startup Sequence (IMPORTANT!)

**Services MUST be started in this exact order:**

### 1. Start Eureka Discovery Server (Port 8761)
```bash
cd eureka-discovery-server
mvn spring-boot:run
```
Wait for console: `Started EurekaDiscoveryServerApplication in X seconds`

### 2. Start Account Service (Port 8080)
```bash
cd account
mvn spring-boot:run
```
Wait for console: `Started AccountApplication in X seconds`

### 3. Start Loan Service (Port 8081)
```bash
cd loan
mvn spring-boot:run
```
Wait for console: `Started LoanApplication in X seconds`

### 4. Start Greet Service (Port 8080 or 8082)
```bash
cd greet-service
mvn spring-boot:run
```
Wait for console: `Started GreetServiceApplication in X seconds`

### 5. Start API Gateway (Port 9090)
```bash
cd api-gateway
mvn spring-boot:run
```
Wait for console: `Started ApiGatewayApplication in X seconds`

**✅ All services should now be running and registered with Eureka!**

## Verify Setup

### 1. Check Eureka Dashboard
**URL:** http://localhost:8761

You should see "Instances currently registered with Eureka":
- ACCOUNT-SERVICE (1) - UP
- LOAN-SERVICE (1) - UP
- GREET-SERVICE (1) - UP
- API-GATEWAY (1) - UP

### 2. Test Individual Services (Direct Access)

#### Account Service
```
URL: http://localhost:8080/accounts/12345
Expected Response:
{ number: "12345", type: "savings", balance: 234343 }
```

#### Loan Service
```
URL: http://localhost:8081/loans/LOAN001
Expected Response:
{ number: "LOAN001", type: "car", loan: 400000, emi: 3258, tenure: 18 }
```

#### Greet Service
```
URL: http://localhost:8080/greet  (or :8082/greet if port conflict)
Expected Response:
Hello World!!!
```

### 3. Test Via API Gateway (Routed Requests)

#### Account Service via Gateway
```
URL: http://localhost:9090/account-service/accounts/12345
Expected Response: Same as direct access (via gateway)
```

#### Loan Service via Gateway
```
URL: http://localhost:9090/loan-service/loans/LOAN001
Expected Response: Same as direct access (via gateway)
```

#### Greet Service via Gateway
```
URL: http://localhost:9090/greet-service/greet
Expected Response: Hello World!!! (via gateway)
```

### 4. Check Global Filter Logging

When accessing via API Gateway, check the **api-gateway console**:

Expected log output:
```
===== Request URL: http://localhost:9090/greet-service/greet
===== Request URL: http://localhost:9090/account-service/accounts/12345
===== Request URL: http://localhost:9090/loan-service/loans/LOAN001
```

## Stopping Services (Reverse Order)

```
1. Stop API Gateway (Ctrl+C in api-gateway terminal)
2. Stop Greet Service (Ctrl+C in greet-service terminal)
3. Stop Loan Service (Ctrl+C in loan terminal)
4. Stop Account Service (Ctrl+C in account terminal)
5. Stop Eureka Server (Ctrl+C in eureka terminal)
```

## Troubleshooting

### Port Already in Use
**Issue:** `java.net.BindException: Address already in use`

**Solution:** Change `server.port` in application.properties
```properties
# Example: use port 8082 instead of 8080
server.port=8082
```

### Service Not Showing in Eureka
**Issue:** Service starts but doesn't appear in Eureka dashboard

**Causes & Solutions:**
1. Eureka Server not running - Start Eureka first (port 8761)
2. Missing @EnableDiscoveryClient - Check application class annotation
3. Wrong Eureka URL - Verify `eureka.client.service-url.defaultZone` in application.properties

### Service Shows UP in Eureka But Not Accessible
**Issue:** Service registered but returns 404 error

**Solution:** Wait 10-15 seconds after seeing in Eureka. Full startup takes time.

### API Gateway Cannot Route to Services
**Issue:** Gateway returns 503 Bad Gateway

**Solutions:**
1. Check `spring.cloud.gateway.discovery.locator.enabled=true` in api-gateway
2. Verify `spring.cloud.gateway.discovery.locator.lower-case-service-id=true`
3. Ensure service names in Eureka match gateway configuration

### Filter Logs Not Showing
**Issue:** No request logs in api-gateway console

**Solutions:**
1. Verify LogFilter class exists in api-gateway
2. Check file: `api-gateway/src/main/java/com/cognizant/api_gateway/filters/LogFilter.java`
3. Ensure filter has @Component annotation

## Key Concepts Demonstrated

### Microservices
- Independent, self-contained Spring Boot applications
- Each handles specific business domain
- Can be deployed separately
- Different ports (8080, 8081, 8082)

### Eureka Service Discovery
- Central registry of all available services
- Services auto-register on startup
- Services auto-deregister on shutdown
- API Gateway queries Eureka for available services

### API Gateway
- Single entry point for all client requests
- Routes requests to appropriate microservices
- Based on URL patterns and service discovery
- Can add cross-cutting concerns (logging, security, etc.)

### Global Filter
- Intercepts all requests passing through gateway
- Used for logging, metrics, security checks
- Example: LogFilter logs every incoming request

### Service-to-Service Communication
- Account, Loan, Greet services are independent
- API Gateway facilitates client-to-service communication
- Can be extended for service-to-service calls using RestTemplate/WebClient

## Project Structure Details

Each microservice follows Maven project standard:
```
service-name/
├── src/
│   ├── main/
│   │   ├── java/com/cognizant/service/
│   │   │   ├── ServiceApplication.java (Main class with @SpringBootApplication)
│   │   │   └── controller/ (REST endpoints)
│   │   └── resources/
│   │       └── application.properties (Configuration)
│   └── test/
├── pom.xml (Maven dependencies)
├── target/ (Compiled files)
└── README.md (Service documentation)
```

## API Endpoints Summary

| Service | Method | Endpoint | Port |
|---------|--------|----------|------|
| Account | GET | /accounts/{number} | 8080 |
| Loan | GET | /loans/{number} | 8081 |
| Greet | GET | /greet | 8080/8082 |
| Gateway | GET | /{service-name}/{endpoint} | 9090 |

## Running in IDE (Eclipse)

Instead of `mvn spring-boot:run`, you can:

1. **Import project in Eclipse:**
   - File → Import → Existing Maven Projects
   - Select the service folder
   - Click Finish

2. **Run as Spring Boot App:**
   - Right-click project → Run As → Spring Boot App
   - (or Spring Boot App on Server)

3. **Open multiple terminals in Eclipse:**
   - Window → Show View → Terminals
   - Use monitor icon to switch between console outputs

## Testing with cURL

```bash
# Test Account Service directly
curl http://localhost:8080/accounts/ACC001

# Test via API Gateway
curl http://localhost:9090/account-service/accounts/ACC001

# Test Greet Service
curl http://localhost:8080/greet
curl http://localhost:9090/greet-service/greet
```

## Common Log Messages (What's Normal)

```
✅ "Starting [ServiceName]Application"
✅ "Registering with Eureka server"
✅ "Netty started on port XXXX"
✅ "Started [ServiceName]Application in X seconds"
⚠️ "WARNING: A terminally deprecated method in sun.misc.Unsafe" (Normal Java warning)
```

## Performance Tips

- Startup takes 10-15 seconds per service (normal)
- Eureka discovery takes 30-90 seconds to propagate
- If service shows UP but returns 404, wait 15 seconds and retry
- Browser refresh helps with DNS caching issues

## Learning Objectives Covered

✅ Microservices Architecture  
✅ Spring Boot 3.4.2  
✅ Spring Cloud Eureka  
✅ Spring Cloud API Gateway  
✅ Global Filters  
✅ Service Registry Pattern  
✅ REST APIs  
✅ API Gateway Pattern  
✅ Service Discovery  
✅ Multi-service Coordination  

## Next Steps / Enhancements

1. Add database connectivity to services
2. Implement service-to-service communication
3. Add security (Spring Security)
4. Implement circuit breaker (Resilience4j)
5. Add metrics and monitoring (Micrometer)
6. Deploy to cloud (AWS, Azure, Heroku)

## Documentation Files

- `README_Documentation_Guide.pdf` - How to create README files
- `Microservices_API_Gateway_Implementation_Guide.pdf` - Technical implementation
- `Greet_Service_Dependency_Setup.pdf` - Spring Initializer setup
- `Complete_Project_Finalization_Guide.pdf` - Completion checklist

## References

- [Spring Cloud Documentation](https://spring.io/cloud)
- [Spring Boot Reference](https://spring.io/projects/spring-boot)
- [Eureka Documentation](https://github.com/Netflix/eureka/wiki)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

## Project Information

**Created:** 2026  
**Last Updated:** July 14, 2026  
**Status:** Complete  
**Version:** 1.0  
**Course:** Cognizant Digital Nurture - Java Full Stack Engineer (FSE)  

---

## Questions or Issues?

1. Check the individual README.md in each service folder
2. Review troubleshooting section above
3. Check Eureka dashboard for service status
4. Verify console logs for errors
5. Ensure startup sequence is followed

---

