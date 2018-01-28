pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: 'hello', name: 'userFlag')
    }

    stages {
        stage("foo") {
            steps {
                echo "flag: ${params.userFlag}"
            }
        }
    }
}
