pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
                    sh script: 'docker build --file dockerfile --tag docker.io/vaibhavgdevops/dockertest:$BUILD_NUMBER .'
                    sh script: 'docker push docker.io/vaibhavgdevops/dockertest:$BUILD_NUMBER'
              }	
           }		
        }
    }
}
