FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8761
CMD ["java", "-jar", "eureka-server.jar"]
