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
                    sh "docker build -t calculator ."
                }
            }
        }

  	
  	
  	stage('Push Docker Image') {
    steps {
        script {
            withCredentials([string(credentialsId: 'docker-hub-credentials', variable: 'DOCKER_HUB_PASS')]) {
                sh "echo \$DOCKER_HUB_PASS | docker login -u vaibhav48 --password-stdin"
                sh "docker tag calculator vaibhav48/calculator:latest"
                sh "docker push vaibhav48/calculator:latest"
                sh "docker logout"
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

