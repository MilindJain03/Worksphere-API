# Use OpenJDK 17 or OpenJDK 20 as the base image
FROM gradle:jdk23-alpine

# Set working directory
WORKDIR /app

# Copy the backend JAR file into the container
COPY build/libs/employee-management-0.0.1-SNAPSHOT.jar app.jar

# Set environment variables for database connection
ENV spring.datasource.url=jdbc:postgresql://localhost:5432/employee_management
ENV spring.datasource.username=postgres
ENV spring.datasource.password=asdf@asdf

ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
