pipeline {
    agent any
    stages {
        stage('Installing tools on slave') {
            steps {
              ansiblePlaybook credentialsId: 'Mastercreds', disableHostKeyChecking: true, installation: 'Ansible', inventory: 'myinv', playbook: 'main.yml'
            }
           
        }
        
    }

}
