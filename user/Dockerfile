FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/user-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8081
CMD ["java", "-jar", "user-service.jar"]
