pipeline {
    agent any

    parameters {
        string(defaultValue: true, description: '', name: 'test')
    }

    stages {
        stage("foo") {
            steps {
                echo "flag: ${params.test}"
            }
        }
    }
}
