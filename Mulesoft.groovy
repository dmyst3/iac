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
        
        stage ('Clone Git Repo') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
    }

    stages {
        
        stage ('Clone Git Repow') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
    }
}
