pipeline {
    agent any

    environment {
        APP = 'app'
        PORT = '5000'
        PORTA_INTERNA = '8000'
        REPO = 'andradesysadmin'
        REMOTE_HOST = 'gabriel@192.168.10.50' 
        REMOTE_DIR = "/home/gabriel/aplicacoes/"
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "Baixando o repositório: ${env.APP} no host remoto..."
                    sh """
                        ssh ${env.REMOTE_HOST} 'git clone git@github.com:${env.REPO}/${env.APP}.git ${env.REMOTE_DIR} || (cd ${env.REMOTE_DIR} && git pull)'
                    """
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Buildando a aplicação ${env.APP} no host remoto..."
                    sh """
                        ssh ${env.REMOTE_HOST} '
                            cd ${env.REMOTE_DIR}
                            cp /var/.envs/${env.APP}/.env . || true
                            sudo docker stop ${env.APP} || true
                            sudo docker rm ${env.APP} || true
                            sudo docker rmi ${env.APP} || true
                            sudo docker build -t ${env.APP}:latest .
                        '
                    """
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Testando a aplicação ${env.APP} no host remoto..."
                    sh """
                        ssh ${env.REMOTE_HOST} '
                            cd ${env.REMOTE_DIR}
                            npm install
                            npx jest --ci --maxWorkers=2
                        '
                    """
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Subindo a aplicação ${env.APP} no host remoto..."
                    sh """
                        ssh ${env.REMOTE_HOST} '
                            cd ${env.REMOTE_DIR}
                            sudo docker run -d -p ${env.PORT}:${env.PORTA_INTERNA} --restart always --name ${env.APP} ${env.APP}:latest
                        '
                    """
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
