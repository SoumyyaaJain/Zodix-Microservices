FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/apigateway-0.0.1-SNAPSHOT.jar apiserver.jar
EXPOSE 8080
CMD ["java", "-jar", "apiserver.jar"]
