pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
              git branch: 'main', url: 'https://github.com/Vaibhav2406/edu-project1.git'
            }
           
        }
        stage('Installing tools on slave') {
            steps {
              ansiblePlaybook credentialsId: 'Mastercreds', disableHostKeyChecking: true, installation: 'Ansible', inventory: 'myinv', playbook: 'Puppet-Push/main.yml'
            }
           
        }
        stage('Deploying Docker on Slave') {
            steps {
              ansiblePlaybook credentialsId: 'Mastercreds', disableHostKeyChecking: true, installation: 'Ansible', inventory: 'myinv', playbook: 'dockerm.yml'
            }
           
        }
       stage('build & push docker image') {
	         steps {
              withDockerRegistry(credentialsId: 'vaibhavgdevops', url: 'https://index.docker.io/v1/') {
                    sh script: 'cd  $WORKSPACE'
		    sh 'chmod 777 /var/run/docker.sock'
		    sh 'docker build --file dockerfile --tag vaibhavgdevops/dockertest:$BUILD_NUMBER .'
		    sh 'docker run -d -t -P vaibhavgdevops/dockertest:$BUILD_NUMBER'
		    sh 'docker push vaibhavgdevops/dockertest:$BUILD_NUMBER'
	            sh 'docker ps'
	           }	
              }		
        }
    }	    
       post {
         failure { 
           script {
                sh 'docker kill $(docker ps -l -q)'
           }
         } 
       }
    }
