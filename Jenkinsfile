pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-login' // You will set this ID in Jenkins later
        APP_NAME = 'inventory-app'
        DOCKER_USER = 'your-dockerhub-username' 
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
                sh "docker build -t ${DOCKER_USER}/${APP_NAME}:${BUILD_NUMBER} ."
                sh "docker tag ${DOCKER_USER}/${APP_NAME}:${BUILD_NUMBER} ${DOCKER_USER}/${APP_NAME}:latest"
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS}", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push ${DOCKER_USER}/${APP_NAME}:${BUILD_NUMBER}"
                    sh "docker push ${DOCKER_USER}/${APP_NAME}:latest"
                }
            }
        }
        
        stage('Deploy with Ansible') {
            steps {
                // This triggers the Ansible playbook we are about to create
                sh 'ansible-playbook -i inventory.ini ansible-deploy.yml'
            }
        }
    }
}
