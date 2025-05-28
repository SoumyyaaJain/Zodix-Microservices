**🌌 Zodix Project: Microservices Execution, Architecture & Deployment Guide**  

**🧠 What Is This Project About?**

Zodix is an astrology-based web application that:

--> Lets users register and securely log in.

--> Offers detailed zodiac sign traits.

--> Provides compatibility information between signs.

--> Uses a Spring Boot microservices architecture.

--> Is containerized using Docker and orchestrated via Kubernetes (KIND).

--> Each component is built as an independent microservice communicating over REST and registered via Eureka.


**🔧 Prerequisites**

1. Before running this project, ensure the following are installed:
2. Java 17
3. Maven 3.8+
4. MySQL 8.0+
5. Docker
6. Docker Compose
7. KIND (Kubernetes in Docker)
8. kubectl
9. Postman (for testing APIs)
10. IntelliJ / VS Code / Eclipse (IDE)

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

1. config-server
2. eureka-server
3. api-server (Gateway)
4. user-service
5. zodiac-service
6. compatibility-service
7. frontend-service


**🧩 Service Breakdown**

1️⃣ Config Server
1. 📍 Port: 8888
2. 🧠 Purpose: Centralized config for all services.
3. 🔗 Endpoint: http://localhost:8888/user-service/default
4. ✅ Use: Ensures externalized config and flexible environments.


2️⃣ Eureka Server
1. 📍 Port: 8761
2. 🧠 Purpose: Service Discovery.
3. 🔗 Endpoint: http://localhost:8761
4. ✅ Use: Allows each service to register/discover others.

3️⃣ API Server (Gateway)
1. 📍 Port: 8080
2. 🧠 Purpose: Routes requests to appropriate services.
3. 🔗 Examples:
   http://localhost:8080/user/hello
   http://localhost:8080/zodiac/aries
4. ✅ Use: Centralized access point for frontend clients.

4️⃣ User Service
1. 📍 Port: 8081
2. 🧠 Purpose: Registration, login, and authentication.
3. 🔐 Security: Uses Spring Security with basic auth (admin/admin)
4. 🔗 Swagger: http://localhost:8081/swagger-ui/index.html
5. ✅ Use: Manages secure user data.

5️⃣ Zodiac Service
1. 📍 Port: 8083
2. 🧠 Purpose: Provides zodiac traits via MySQL DB.
3. 🔗 Swagger: http://localhost:8083/swagger-ui/index.html
4. ✅ Use: Core astrology info provider.

6️⃣ Compatibility Service
1. 📍 Port: 8084
2. 🧠 Purpose: Gives zodiac compatibility results.
3. 🔗 Swagger: http://localhost:8084/swagger-ui/index.html
4. ✅ Use: Adds engagement by comparing zodiac signs.

7️⃣ Frontend Service
1. 📍 Port: 8085
2. 🧠 Purpose: Basic Thymeleaf-based UI for demo.
3. 🔗 Endpoint: http://localhost:8085/home
4. ✅ Use: Helps visualize microservice flow.

**🔄 API Gateway Routing Tests**
1. http://localhost:8080/user/hello
2. http://localhost:8080/zodiac/aries
3. http://localhost:8080/compatibility/aries-taurus

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
1. Navigate to each service folder (e.g., user-service).
2. Run:
./mvnw clean package
or
mvn clean package
3. JAR will be at: target/<service-name>-0.0.1-SNAPSHOT.jar

**🔄 Essential Changes Made for Functionality**
1. Added Swagger UI in each microservice (springdoc-openapi-ui).
2. Spring Security added to user-service with admin/admin creds.
3. Eureka configured in all services.
4. API Gateway routes written in application.properties.
5. Config Server externalized with bootstrap.yml and application.yml.
6. Unique ports per microservice.
7. Dockerfiles created for all services.
8. docker-compose.yml created for orchestration.
9. Kubernetes YAMLs created in /k8s folder.
10. JWT-based Auth planned for future security.

**☸️ Kubernetes (KIND)**

▶️ Steps:
1. kind create cluster
2. kubectl apply -f k8s/
3. kubectl get pods
4. kubectl get services

📂 Folder Structure:
k8s/
|- config-server.yaml
|- eureka-server.yaml
|- api-server.yaml
|- user-service.yaml
|- zodiac-service.yaml
|- compatibility-service.yaml

**💡 Future Suggestions**
1. Implement JWT-based security across services.
2. Shift to centralized MongoDB/PostgreSQL via Docker.
3. Add Prometheus/Grafana for observability.
4. Add OAuth2 for third-party login.
5. Deploy to AWS/GCP using Helm.
6. Build a React frontend + Android app.
7. Use API Gateway filters for logging and throttling.

**✅ Feature Summary**

Component:                      Purpose
1. Spring Boot:                  Microservice framework
2. Spring Cloud:                 Config, Discovery, Gateway
3. Spring Security:              Auth for user-service
4. Swagger UI:                   API Documentation
5. Docker:                       Containerization
6. Kubernetes (KIND):            Container orchestration
7. MySQL:                        User & Zodiac database
8. Thymeleaf:                    Simple frontend demo

