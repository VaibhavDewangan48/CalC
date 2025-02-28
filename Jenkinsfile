pipeline {
    agent any  // Runs on any available agent

    tools {
        maven 'Maven 3.8.1' // Ensure Maven is installed in Jenkins
        jdk 'OpenJDK 21'  // Use the appropriate JDK version
    }

    environment {
        MVN_CMD = 'mvn clean package' // Maven command to build the project
        DOCKER_IMAGE = 'your-dockerhub-username/scicalculator:latest' // Define Docker image name
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
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
            withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                sh '''
                echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                docker tag calculator "$DOCKER_USERNAME"/calculatortest
                docker push "$DOCKER_USERNAME"/calculatortest
                docker logout
                '''
            }
        }
    }
}

  	


    stage('Deploy with Ansible') {
            steps {
               sh '''
        sudo ansible-playbook ~/Desktop/CalC/SciCalculator/deploy.yml \
        -e "docker_hub_username=your_username docker_hub_password=your_password"
        '''
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

