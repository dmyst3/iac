pipeline {
    agent any

    parameters {
        string(defaultValue: 'Hello this is param 1', description: '', name: 'param1')
        string(defaultValue: 'Hello this is param 2', description: '', name: 'param2')
    }

    stages {
        stage("Print Params") {
            steps {
                echo "flag: ${params.param1}"
                echo "flag: ${params.param2}"
            }
        }
    }
}
