# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS ems_backend_builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal JRE image
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=ems_backend_builder /app/target/mss-hospital-management-system-0.0.1-SNAPSHOT.jar mss-hms.jar

EXPOSE 8081

# Specify the default command to run on startup
CMD ["java", "-jar", "mss-hms.jar"]