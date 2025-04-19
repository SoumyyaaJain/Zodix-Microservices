FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/zodiac-0.0.1-SNAPSHOT.jar zodiac-service.jar
EXPOSE 8083
CMD ["java", "-jar", "zodiac-service.jar"]
