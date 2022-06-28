pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
		    sh 'docker pull devopsedu/webapp'
		    sh 'docker run -d -t -P devopsedu/webapp'
		    sh 'read CONTAINERID'
		    sh 'echo $CONTAINERID'
              }	
           }		
        }
    }
}
