pipeline {
    agent any
    stages {
      stage('Removing container') {
	         steps {
              sh 'docker kill $(docker ps -l -q)'
           }
       }
    }
}
