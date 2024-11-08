pipeline {
    agent any

    environment {
        APP='frontend'
        REPO='andradesysadmin'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "Baixando o repositório: ${env.APP}..."
                    git branch: 'main', url: "git@github.com:${env.APP}/${env.APP}.git"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Buildando a aplicação ${env.APP}..."
                    sh 'ls -la'
                    sh "cp /var/.envs/${env.APP}/.env* ."
                    sh 'sudo rm -rf node_modules/'
                    sh 'sudo npm i'
                    sh 'sudo npm run build'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Testando a aplicação ${env.APP}..."
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Subindo a aplicação ${env.APP}..."
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline executada com sucesso!"
        }
        failure {
            echo "A pipeline falhou!"
        }
    }
}
