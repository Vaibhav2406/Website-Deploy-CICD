#!/bin/bash  
pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
		    sh 'docker build --file dockerfile --tag vaibhavgdevops/dockertest:$BUILD_NUMBER .'
		    sh 'docker run -d -t -P vaibhavgdevops/dockertest:$BUILD_NUMBER'
		    sh 'docker push vaibhavgdevops/dockertest:$BUILD_NUMBER'
		    sh 'docker ps'
	      }	
           }		
        }
    }
}
