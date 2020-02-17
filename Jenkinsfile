/*
pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version; java --version'
            }
        }
    }
}
*/


/*

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}
*/

/*
//There are some powerful steps that "wrap" other steps which can easily solve problems
//like retrying (retry) steps until successful or exiting if a step takes too long (timeout).
pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                retry(3) {
                    sh './flakey-deploy.sh'
                }

                timeout(time: 3, unit: 'MINUTES') {
                    sh './health-check.sh'
                }
            }
        }
    }
}
*/


/*
//we wanted to retry our deployment 5 times,
//but never want to spend more than 3 minutes in total before failing the stage
pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    retry(5) {
                        sh './flakey-deploy.sh'
                    }
                }
            }
        }
    }
}
*/


/*
//When the Pipeline has finished executing,
//you may need to run clean-up steps or perform some actions
//based on the outcome of the Pipeline.
//These actions can be performed in the post section.
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'echo "Success"; exit 0'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
*/

/*
//Pipeline is designed to easily use Docker images and containers to run inside.
//This allows the Pipeline to define the environment and tools required without
//having to configure various system tools and dependencies on agents manually. 
//This approach allows you to use practically any tool which can be packaged in a Docker container.
pipeline {
    agent {
        docker { image 'node:7-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}
*/


//Environment variables can be set globally, like the example below, or per stage. 
//As you might expect, setting environment variables per stage means they will only 
//apply to the stage in which they’re defined.
pipeline {
    agent {
        label '!windows'
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }

    stages {
        stage('Build') {
            steps {
                echo "Database engine is ${DB_ENGINE}"
                echo "DISABLE_AUTH is ${DISABLE_AUTH}"
                sh 'printenv'
            }
        }
    }
}
