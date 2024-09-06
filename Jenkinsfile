pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3.9.9', type: 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Pooj3196/MovieManagement.git'
            }
        }

        stage('Build and Test') {
            steps {
                withMaven(maven: 'Maven 3.9.9') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                sh './scripts/deploy-to-staging.sh'
            }
        }

        stage('Approval for Production') {
            steps {
                input message: 'Approve deployment to production?', ok: 'Deploy'
            }
        }

        stage('Deploy to Production') {
            steps {
                sh './scripts/deploy-to-production.sh'
            }
        }
    }

    post {
        success {
            mail to: 'poojagosavi318@gmail.com',
                 subject: 'Build Successful',
                 body: 'The build and deployment were successful!'
        }
        failure {
            mail to: 'poojagosavi318@gmail.com',
                 subject: 'Build Failed',
                 body: 'The build or deployment failed. Please check Jenkins for details.'
        }
    }
}
