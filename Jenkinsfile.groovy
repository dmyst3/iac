pipeline {
    agent any

    parameters {
        string(defaultValue: 'hello from jenkins param', description: '', name: 'test')
    }

    stages {
        stage("foo") {
            steps {
                echo "flag: ${params.test}"
            }
        }
    }
}
