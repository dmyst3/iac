pipeline {
    tools{
        maven 'maven'
        ansible 'ansible'
    }
    agent{ 
        label 'master'
    }
    
    options{
        buildDiscarder(logRotator(numToKeepStr:'5'))
        timeout(time: 10, unit: 'MINUTES')
    }

    stages {
        stage ('Code Build') {
            agent{ 
                label 'master'
            }
                steps {
                    sh 'mvn -B clean package'
                }
        }

        stage ('Deploy to dev') {
            agent{ 
                label 'master'
            }
                steps {
                    ansiblePlaybook {
                        playbook: 'play.yml'
                    }
                }
        }
        
    }
}
