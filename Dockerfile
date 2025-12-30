FROM openjdk:17-jdk-slim
WORKDIR /app
# The wildcard ensures it finds the file even if the version name changes
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
