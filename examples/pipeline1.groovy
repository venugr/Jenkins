pipeline {
    
    agent any
    
    environment {
        AWS_ID  = credentials('AWS_KEY_ID')
        AWS_KEY = credentials('AWS_ACCESS_KEY')
        USERPWD  = credentials('USERPWD')
       CCL = 'clang'
       CC = """${sh(
                returnStdout: true,
                script: 'echo "javalang"'
            )}""" 
        
       EXIT_STATUS = """${sh(
                returnStatus: true,
                script: 'exit 1'
            )}"""
    }
    
    stages() {
        stage("ENV") {
            steps() {
                script {
                   echo "${env}"
                   env.each() {
                      echo "${it}"
                   }
                   echo "BuildUrl: ${BUILD_URL}"
                   echo "BuildUrl: ${env.BUILD_URL}"
                   echo "JobUrl: ${JOB_URL}"
                }
            }
        }
        
        stage("CurrentBuild") {
            steps() {
                script {
                    echo "Number: ${currentBuild.number}"
                    echo "DisplayName: ${currentBuild.displayName}"
                    echo "FullDisplayName: ${currentBuild.fullDisplayName}"
                    echo "ProjectName: ${currentBuild.projectName}"
                    echo "FullProjectName: ${currentBuild.fullProjectName}"
                }
            }
        }
        
        stage ("AnsiColor") {
            steps() {
               ansiColor('xterm') {
                  echo "\u001B[31mI'm Red\u001B[0m Now not"
               }
            }
        }
        
        stage ("Env Variables") {
            environment {
               FLAGS = 'debug -g'
            }
            steps() {
                sh "printenv | sort"
                script {
                   def key = AWS_KEY
                   //key = "Start,"+key+",Hello"
                   key.split("a").each() {
                      echo "ID=${it}"
                   }
                   
                   echo "USERPWD=${USERPWD}"
                   echo "USERID=${USERPWD_USR}"
                   echo "USERPWD=${USERPWD_PSW}"
                   echo "Work?User?=usrAdmin"
                   echo "Work?Pwd?=pwdAdmin"
                   echo "Work?User?=usr1Admin"
                   echo "Work?Pwd?=pwd1Admin"
                }
            }
        }
        
        stage ("COPY Artifacts") {
            steps() {
               copyArtifacts projectName: 'ArchiveArtifact'
            }
        }    
        
    }
    
    
}

