pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
                    sh script: 'docker build --file Dockerfile --tag docker.io/lerndevops/petclinic:$BUILD_NUMBER .'
                    sh script: 'docker push docker.io/lerndevops/petclinic:$BUILD_NUMBER'
              }	
           }		
        }
