# Use Amazon Corretto (OpenJDK) from the ECR Public Gallery to avoid Docker Hub limits
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17-al2-jdk

# Set the working directory
WORKDIR /app

# Copy the JAR file (we saw it exists in your logs as inventory-app-0.0.1-SNAPSHOT.jar)
COPY target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
