pipeline {
    agent any
    parameters {
        choice(name: 'Environment',choices: "Dev\nTest\nProd", description: 'interesting stuff' )
        string(name: 'Client', defaultValue: 'rmu-test', description: 'How should I greet the world?')
        
        
    }
    stages {
        stage('Example') {
            steps {
                echo "${params.Greeting} World!"
            }
        }
    }
}
