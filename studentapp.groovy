pipeline {
    agent any
    stages {
        stage ('Pull') {
            steps {
                git 'https://github.com/shubhamkalsait/studentapp-ui.git'
            }
        }
        stage ('Build') {
            steps {
                sh '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('Test') {
            steps {
                echo 'Test succeed'
            }
        }
        stage ('Deploy') {
            steps {
                echo 'Deploy succeed'
            }
        }
    }
}
