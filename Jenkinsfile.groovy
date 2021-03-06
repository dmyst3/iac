pipeline {
    agent {
        label 'LAMP'
    }
    
    options{
        buildDiscarder(logRotator(numToKeepStr:'5'))
        timeout(time: 10, unit: 'MINUTES')
    }

    parameters {
        string(defaultValue: 'Hello this is param 1', description: '', name: 'param1')
        string(defaultValue: 'Hello this is param 2', description: '', name: 'param2')
        booleanParam(defaultValue: true, description: '', name: 'Flag1')
    }
    environment {
        MY_ENVAR1 = "My Env Var1"
        MY_ENVAR2 = "My Env Var2"
    }

    stages {
        
        stage ('Initialize') {
            steps {
                sh "hostname"
                sh "php -v"
                sh "composer -v"
            }
        }
        stage ('Excute another Job') {
            steps {

                script{
                    def res = build job: 'test-free-style', propagate: false, quietPeriod: 0
                       if (res.resultIsWorseOrEqualTo("SUCCESS")) {
                           res.rawBuild.getLog(100).each { line -> 
                           echo line
                           }
                       }
                       else (res.resultIsWorseOrEqualTo("FAILURE")) {
                           res.rawBuild.getLog(100).each { line -> 
                           echo line
                           error(line)
                           currentBuild.result = 'FAILURE'
                           }
                       }
                }
            }
        }
            stage("Print Params") {
                steps {
                    echo "param1: ${params.param1}"
                    echo "param2: ${params.param2}"
                    echo "Flag1: ${params.Flag1}"
            }
        }
            stage("Print Custom Defined ENV Vars") {
                steps {
                    echo "MY_ENVAR1 is: $MY_ENVAR1"
                    echo "MY_ENVAR2 is: $MY_ENVAR2"
                    echo "MY_Build_Number is: ${env.BUILD_NUMBER}"
            }
        }
            stage("Print Jenkins ENV Vars") {
                steps {
                    echo "MY_Build_Number is: ${env.BUILD_NUMBER}"
                    echo "MY_Build_JOB_NAME is: ${env.JOB_NAME}"
                    echo "MY_Build_BUILD_URL is: ${env.BUILD_URL}"
            }
        }
            stage('Parallel Job') {
                parallel  {
                    stage("Print Custom Defined ENV Vars1") {
                        steps {
                            echo "MY_ENVAR1 is: $MY_ENVAR1"
                            echo "MY_ENVAR2 is: $MY_ENVAR2"
                            echo "MY_Build_Number is: ${env.BUILD_NUMBER}"
                    }
                }
                    stage("Print Jenkins ENV Vars1") {
                        steps {
                            echo "MY_Build_Number is: ${env.BUILD_NUMBER}"
                            echo "MY_Build_JOB_NAME is: ${env.JOB_NAME}"
                            echo "MY_Build_BUILD_URL is: ${env.BUILD_URL}"
                    }
                }
            }
        }
    }
}
