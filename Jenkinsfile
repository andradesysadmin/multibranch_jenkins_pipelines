pipeline {
    agent any

    environment {
        APP = 'app_2'
        PORT = '8001'
        PORTA_INTERNA = '8000'
        REPO='andradesysadmin'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "Baixando o repositório: ${env.APP}..."
                    git branch: 'main', url: "git@github.com:${env.REPO}/${env.APP}.git"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Buildando a aplicação ${env.APP}..."
                    sh 'ls -la'
                    sh "cp /var/.envs/${env.APP}/.env ."
                    sh "sudo docker stop ${env.APP} || true"
                    sh "sudo docker rm ${env.APP} || true"
                    sh "sudo docker rmi ${env.APP} || true"
                    sh "sudo docker build -t ${env.APP}:latest ."
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Testando a aplicação ${env.APP}..."
                    sh "npm i"
                    sh "npx jest --ci --maxWorkers=2"

                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo "Subindo a aplicação ${env.APP}..."
                    sh "sudo docker run -d -p ${env.PORT}:${env.PORTA_INTERNA} --restart always --name ${env.APP} ${env.APP}:latest"
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
