pipeline {
    agent any

    parameters {
        string(defaultValue: 'hello from jenkins param', description: '', name: 'test')
        string(defaultValue: 'hello from jenkins param1', description: '', name: 'test1')
    }

    stages {
        stage("Print Params") {
            steps {
                echo "flag: ${params.test}"
                echo "flag: ${params.test1}"
            }
        }
    }
}
