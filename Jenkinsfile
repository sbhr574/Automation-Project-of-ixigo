pipeline{
  agent any
       environment {
         maven = '${MVN_HOME}'
         jdk = '${JAVA_HOME}'
    }
    stages {
      stage('Git Checkout'){
        steps{
           echo 'Git repo checkout operation'
        }
     }
          stage ('Build') {
            steps {
                bat 'mvn clean package' 
            }
        }

  }
  post{
    success{
                script{
                  currentBuild.result = 'SUCCESS'
                  currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result

                }
              }
              failure {
            // in case of failure, we'd like to have simple 'git blame' on build history :)
            script{
            currentBuild.result = 'FAILED'
            currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result
            buildDescription("Committer: ${GERRIT_PATCHSET_UPLOADER_NAME}")
          }
        }
  }
}
