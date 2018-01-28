pipeline {
    agent any

    parameters {
        string(defaultValue: 'Hello this is param 1', description: '', name: 'param1')
        string(defaultValue: 'Hello this is param 2', description: '', name: 'param2')
    }
    environment {
        MY_ENVAR1 = "My Env Var1"
        MY_ENVAR2 = "My Env Var2"
    }

    stages {
        stage("Print Params") {
            steps {
                echo "flag: ${params.param1}"
                echo "flag: ${params.param2}"
            }
        }
        stage("Print ENV Vars") {
            steps {
                echo "MY_ENVAR1 is: $MY_ENVAR1"
                echo "MY_ENVAR2 is: $MY_ENVAR2"
            }
        }
    }
}
