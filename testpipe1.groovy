parameters {
        choice(name: 'Environment',choices: "Dev\nTest\nProd", description: 'interesting stuff' )
        string(name: 'Client', defaultValue: 'rmu-test', description: 'How should I greet the world?')
        booleanParam(defaultValue: false, name: 'ProceedWithBuild', description: 'Process option 1')
    }

pipeline {
    agent any
    /*
    parameters {
        choice(name: 'Environment',choices: "Dev\nTest\nProd", description: 'interesting stuff' )
        string(name: 'Client', defaultValue: 'rmu-test', description: 'How should I greet the world?')
        booleanParam(defaultValue: false, name: 'ProceedWithBuild', description: 'Process option 1')
    }
    */
    
    stages {
        stage('Example') {
            steps {
                echo "${params.Client} World!"
            }
        }
    }
}
