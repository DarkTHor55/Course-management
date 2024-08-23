## Base image for build
#FROM maven:3.9.8-eclipse-temurin-21 AS build
#
## Working directory
#WORKDIR /app
#
## Copy Maven project files
#COPY pom.xml .
#COPY src ./src
#
## Build application
#RUN mvn clean package
#
## Base image for running the application
#FROM openjdk:22-jdk-slim
#
## Volume for application data
#VOLUME /tmp
#
## Argument for JAR file location
#ARG JAR_FILE=target/Courses-0.0.1-SNAPSHOT.jar
#
## Copy the JAR file from the build stage
#COPY --from=build /app/${JAR_FILE} app.jar
#
## Run the application
#ENTRYPOINT ["java", "-jar", "/app.jar"]
