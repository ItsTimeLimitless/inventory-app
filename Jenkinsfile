pipeline {
    agent any
    
    tools {
        maven 'maven3'
    }

    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-login'
        APP_NAME = 'inventory-app'
        DOCKER_USER = 'admin' 
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
        
        stage('Build & Push Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_USER}/${APP_NAME}:latest ."
                    withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS}", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push ${DOCKER_USER}/${APP_NAME}:latest"
                    }
                }
            }
        }
        
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini ansible-deploy.yml'
            }
        }
    }
}
