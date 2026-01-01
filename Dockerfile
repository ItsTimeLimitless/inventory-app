# Use a smaller runtime image to save disk space
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy the jar file from the target folder
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
