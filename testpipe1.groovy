pipeline {
    agent any
    /*
    parameters {
        choice(name: 'Environment',choices: "Dev\nTest\nProd", description: 'interesting stuff' )
        string(name: 'Client', defaultValue: 'rmu-test', description: 'How should I greet the world?')
        booleanParam(defaultValue: false, name: 'ProceedWithBuild', description: 'Process option 1')
    }
    */
    parameters([
        [$class: 'ChoiceParameter', 
            choiceType: 'PT_SINGLE_SELECT', 
            description: 'Select the Env Name from the Dropdown List', 
            filterLength: 1, 
            filterable: true, 
            name: 'Env', 
            randomName: 'choice-parameter-5631314439613978', 
            script: [
                $class: 'GroovyScript', 
                fallbackScript: [
                    classpath: [], 
                    sandbox: false, 
                    script: 
                        'return[\'Could not get Env\']'
                ], 
                script: [
                    classpath: [], 
                    sandbox: false, 
                    script: 
                        'return["Dev","QA","Stage","Prod"]'
                ]
            ]
        ]])
    
    stages {
        stage('Example') {
            steps {
                echo "${params.Client} World!"
            }
        }
    }
}
