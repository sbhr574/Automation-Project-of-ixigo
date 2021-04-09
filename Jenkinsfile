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
      post {
        success{
          currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result.number
        }
        failure {
            // in case of failure, we'd like to have simple 'git blame' on build history :)
            currentBuild.displayName = 'This build needs help!!!'
            buildDescription("Committer: ${GERRIT_PATCHSET_UPLOADER_NAME}")
        }
    }
}
