

# Base image for running the application
FROM openjdk:19-alpine

WORKDIR /app

COPY target/Courses-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
