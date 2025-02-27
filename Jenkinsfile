pipeline {
    agent any  // Runs on any available agent

    tools {
        maven 'Maven 3.8.1' // Ensure Maven is installed in Jenkins
        jdk 'OpenJDK 21'  // Use the appropriate JDK version
    }

    environment {
        MVN_CMD = 'mvn clean package' // Maven command to build the project
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/VaibhavDewangan48/CalC.git'
            }
        }

        stage('Build') {
            steps {
                sh "${MVN_CMD}"
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'  // Run JUnit tests
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' // Publish test results
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'  // Creates the final JAR
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Add deployment steps if needed (e.g., Docker, Kubernetes)
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
