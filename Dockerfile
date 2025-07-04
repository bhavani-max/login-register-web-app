# Start from a base image with Java 17 or higher
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the Maven project
COPY . .

# Package the application (Maven must be installed inside container)
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/auth-0.0.1-SNAPSHOT.jar"]
