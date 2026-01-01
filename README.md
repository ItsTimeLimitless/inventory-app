Simplilearn AWS Project

# BankPro Inventory Management System
### Core Banking Microservice - Capstone Project

This repository contains the source code and automation scripts for the BankPro Core Banking microservice. The project demonstrates a full CI/CD pipeline using modern DevOps tools.

##  Tech Stack
*   **Java 17 & Spring Boot 3**: Core application framework.
*   **Maven**: Build and dependency management.
*   **Docker**: Containerization for consistent environments.
*   **Jenkins**: CI/CD automation server.
*   **Ansible**: Infrastructure as Code and automated deployment.
*   **AWS EC2**: Cloud hosting environment.

##  CI/CD Pipeline Stages
1. **Checkout**: Pulls the latest code from GitHub.
2. **Build App**: Compiles Java code and packages it into a JAR using Maven.
3. **Build Docker Image**: Creates a lightweight Alpine-based container image.
4. **Deploy with Ansible**: Automatically deploys the container to the AWS production server.

##  API Documentation
Once deployed, the interactive API documentation (Swagger UI) is available at:
`http://<AWS-IP>:8089/bank-api/swagger-ui.html`
