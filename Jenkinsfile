pipeline {
    agent any
    stages {
        stage('Git checkout') {
            steps {
               git 'https://github.com/Vaibhav2406/edu-project1.git'
            }
        }
        stage('Installing tools on slave') {
            steps {
               bat 'terraform plan'
            }
           
        }
        stage('Terraform apply') {
            steps {
               bat 'terraform apply --auto-approve'
            }
        }
        
    }

}
