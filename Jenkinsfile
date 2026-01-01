pipeline {
    agent any
    
    tools {
        maven 'maven3'
    }

    environment {
        APP_NAME = 'inventory-app'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                // We just build it locally and keep it on this machine
                sh "docker build -t ${APP_NAME}:latest ."
            }
        }
        
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini ansible-deploy.yml'
            }
        }
    }
}
