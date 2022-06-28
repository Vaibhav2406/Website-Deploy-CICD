pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
		    sh 'docker pull devopsedu/webapp'
		    sh 'docker run -d -t -P devopsedu/webapp /root'
		    sh 'docker ps'
                    #sh script: 'docker build --file dockerfile --tag docker.io/vaibhavgdevops/dockertest:$BUILD_NUMBER .'
                    #sh script: 'docker push docker.io/vaibhavgdevops/dockertest:$BUILD_NUMBER'
              }	
           }		
        }
    }
}
