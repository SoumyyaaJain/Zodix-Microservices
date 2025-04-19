FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/compatibility-0.0.1-SNAPSHOT.jar compatibility-service.jar
EXPOSE 8082
CMD ["java", "-jar", "compatibility-service.jar"]

