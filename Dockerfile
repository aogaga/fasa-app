FROM eclipse-temurin:21


WORKDIR /app

# Copy the built JAR (from local build)
COPY build/libs/*.jar app.jar

# Expose the Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]