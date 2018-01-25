pipeline {
    agent none
    stages {
        /*Continuous Integration STARTED*/

                stage('Cloning GIT Repo') {
                    agent none
                    steps {
                        echo  'Cloned Git repo'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Code Scan') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Test Code Merge') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }

                stage('Code Build') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Unit Test') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Publish Snapshot') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }

            stage('DEV,QA and ET Deployments') {
            parallel {
                stage('Deploy snapshot to DEV') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }

                stage('Deploy snapshot to QA') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Deploy snapshot to ET') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
            }
    }
        /*Continuous Delivery STARTED*/

        stage('Continuous Delivery') {
            parallel {
                stage('Run ST Test') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Deploy to RT(UAT)') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Run ST RT(UAT)') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Deploy to Pre-Prod') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Run Performance Test') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
            }
        }

       /*DEPLOYMENTED STARTED*/ 
        stage('Deployment') {
            parallel {
                stage('Deployment Approval') {
                    agent none
                    steps {
                        input 'Deploy to prod?'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
                stage('Test On Linux') {
                    agent none
                    steps {
                        echo 'post hello'
                    }
                    post {
                        always {
                            echo 'post hello'
                        }
                    }
                }
            }
        }
    }
}
