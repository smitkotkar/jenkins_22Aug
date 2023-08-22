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
        // stage ('Test') {
        //     steps {
        //         sh '/opt/apache-maven/bin/mvn sonar:sonar   -Dsonar.projectKey=studentapp   -Dsonar.host.url=http://54.173.83.49:9000   -Dsonar.login=3a3d798cc376e4c2efb54b716c4104106efe6bf9'
        //     }
        // }
        stage ('test') {
            steps {
                withSonarQubeEnv(installationName:'sonar-server',credentialsId: 'sonar_token') { 
                  sh '/opt/apache-maven/bin/mvn sonar:sonar -Dsonar.ProjectKey=studentapp'
               }
            }
        }
        stage ('Deploy') {
            steps {
                echo 'Deploy succeed'
            }
        }
    }
}
