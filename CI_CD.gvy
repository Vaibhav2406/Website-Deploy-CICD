pipeline {
    agent any
    stages {
      stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
		    sh 'docker pull devopsedu/webapp'
		    sh 'var1=$(docker run -d -t -P devopsedu/webapp)'  
		    sh 'wget https://github.com/mfieldhouse/docker-php-helloworld/archive/refs/heads/master.zip -P /home'
		    sh 'unzip master.zip'
		    sh 'docker cp -r /tmp/projCert-master/website var1:/var/www/html'
              }	
           }		
        }
    }
}
