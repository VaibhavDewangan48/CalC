pipeline {
    agent any  // Runs on any available agent

    tools {
        maven 'Maven 3.8.1' // Ensure Maven is installed in Jenkins
        jdk 'OpenJDK 21'  // Use the appropriate JDK version
    }

    environment {
        MVN_CMD = 'mvn clean package' // Maven command to build the project
        DOCKER_IMAGE = 'your-dockerhub-username/scicalculator:latest' // Define Docker image name
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/VaibhavDewangan48/CalC.git'
            }
        }

        stage('Build') {
            steps {
                dir('SciCalculator') {  
                    sh "${MVN_CMD}"
                }
            }
        }

        stage('Test') {
            steps {
                dir('SciCalculator') {  
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit 'SciCalculator/target/surefire-reports/*.xml' // Corrected path for test reports
                }
            }
        }

        stage('Package') {
            steps {
                dir('SciCalculator') {  
                    sh 'mvn package'
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                dir('SciCalculator') {
                    sh "sudo docker build -t calculator ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credentials') { // Replace with Jenkins credentials ID
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add deployment steps (e.g., Docker container run, Kubernetes deployment)
            }
        }
    }

    post {
        success {
            echo 'Build and tests passed! ✅'
        }
        failure {
            echo 'Build failed! ❌'
        }
    }
}

