**🌌 Zodix Project: Microservices Execution, Architecture & Deployment Guide
**  

**🧠 What Is This Project About?**
Zodix is an astrology-based web application that:
Lets users register and securely log in.
Offers detailed zodiac sign traits.
Provides compatibility information between signs.
Uses a Spring Boot microservices architecture.
Is containerized using Docker and orchestrated via Kubernetes (KIND).
Each component is built as an independent microservice communicating over REST and registered via Eureka.

**🔧 Prerequisites**
Before running this project, ensure the following are installed:
Java 17
Maven 3.8+
MySQL 8.0+
Docker
Docker Compose
KIND (Kubernetes in Docker)
kubectl
Postman (for testing APIs)
IntelliJ / VS Code / Eclipse (IDE)

**🗂️ Order of Microservice Execution (Local Dev)**
To run the project locally (before Docker/Kubernetes), start services in this order:
1. config-server
2. eureka-server
3. user-service
4. zodiac-service
5. compatibility-service
6. api-server (gateway)
7. frontend-service


**📦 Project Structure Overview**
config-server
eureka-server
api-server (Gateway)
user-service
zodiac-service
compatibility-service
frontend-service

**🧩 Service Breakdown**

1️⃣ Config Server
📍 Port: 8888
🧠 Purpose: Centralized config for all services.
🔗 Endpoint: http://localhost:8888/user-service/default
✅ Use: Ensures externalized config and flexible environments.

2️⃣ Eureka Server
📍 Port: 8761
🧠 Purpose: Service Discovery.
🔗 Endpoint: http://localhost:8761
✅ Use: Allows each service to register/discover others.

3️⃣ API Server (Gateway)
📍 Port: 8080
🧠 Purpose: Routes requests to appropriate services.
🔗 Examples:
http://localhost:8080/user/hello
http://localhost:8080/zodiac/aries
✅ Use: Centralized access point for frontend clients.

4️⃣ User Service
📍 Port: 8081
🧠 Purpose: Registration, login, and authentication.
🔐 Security: Uses Spring Security with basic auth (admin/admin)
🔗 Swagger: http://localhost:8081/swagger-ui/index.html
✅ Use: Manages secure user data.

5️⃣ Zodiac Service
📍 Port: 8083
🧠 Purpose: Provides zodiac traits via MySQL DB.
🔗 Swagger: http://localhost:8083/swagger-ui/index.html
✅ Use: Core astrology info provider.

6️⃣ Compatibility Service
📍 Port: 8084
🧠 Purpose: Gives zodiac compatibility results.
🔗 Swagger: http://localhost:8084/swagger-ui/index.html
✅ Use: Adds engagement by comparing zodiac signs.

7️⃣ Frontend Service
📍 Port: 8085
🧠 Purpose: Basic Thymeleaf-based UI for demo.
🔗 Endpoint: http://localhost:8085/home
✅ Use: Helps visualize microservice flow.

🔄 API Gateway Routing Tests
http://localhost:8080/user/hello
http://localhost:8080/zodiac/aries
http://localhost:8080/compatibility/aries-taurus

**🐳 Docker**

▶️ Build & Run:
docker-compose up --build

🔍 Check:
docker ps

🗂️ Access:
http://localhost:<assigned_port>

📌 Note:
Prebuilt JAR files are removed from GitHub. Rebuild JARs before running Docker/Kubernetes.

**🔨 How to Rebuild JAR Files**

Navigate to each service folder (e.g., user-service).

Run:
./mvnw clean package
or
mvn clean package

JAR will be at: target/<service-name>-0.0.1-SNAPSHOT.jar

**🔄 Essential Changes Made for Functionality**
✨ Added Swagger UI in each microservice (springdoc-openapi-ui).
🔐 Spring Security added to user-service with admin/admin creds.
🔗 Eureka configured in all services.
🌐 API Gateway routes written in application.properties.
📁 Config Server externalized with bootstrap.yml and application.yml.
🧩 Unique ports per microservice.
🐳 Dockerfiles created for all services.
📦 docker-compose.yml created for orchestration.
☸️ Kubernetes YAMLs created in /k8s folder.
🔐 JWT-based Auth planned for future security.

**☸️ Kubernetes (KIND)**

▶️ Steps:
kind create cluster
kubectl apply -f k8s/
kubectl get pods
kubectl get services

📂 Folder Structure:
k8s/
  |- config-server.yaml
  |- eureka-server.yaml
  |- api-server.yaml
  |- user-service.yaml
  |- zodiac-service.yaml
  |- compatibility-service.yaml

**💡 Future Suggestions**
✅ Implement JWT-based security across services.
📦 Shift to centralized MongoDB/PostgreSQL via Docker.
📈 Add Prometheus/Grafana for observability.
🔐 Add OAuth2 for third-party login.
📤 Deploy to AWS/GCP using Helm.
📱 Build a React frontend + Android app.
🛠️ Use API Gateway filters for logging and throttling.

**✅ Feature Summary**

Component                    Purpose

Spring Boot                  Microservice framework

Spring Cloud                 Config, Discovery, Gateway

Spring Security              Auth for user-service

Swagger UI                   API Documentation

Docker                       Containerization

Kubernetes (KIND)            Container orchestration

MySQL                        User & Zodiac database

Thymeleaf                    Simple frontend demo

