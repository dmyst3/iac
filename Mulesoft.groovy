pipeline {
    tools{
        maven 'maven'
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
            steps {
                sh 'mvn -B clean package'
            }
        }
        
    }
}
