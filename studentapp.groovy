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
                echo 'Build succeed'
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
