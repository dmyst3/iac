pipeline {
    agent any

    parameters {
        string(defaultValue: 'Testing param', 
                     description: '', 
                     name: 'userFlag'
                    )
    }

    stages {
        stage("foo") {
            steps {
                echo "flag: ${params.userFlag}"
            }
        }
    }
}
