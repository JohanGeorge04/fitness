# Use a Maven image to build the application
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use an OpenJDK 17 runtime environment to run the application
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/fitness-0.0.1-SNAPSHOT.jar /app/fitness.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java", "-jar", "/app/fitness.jar"]
