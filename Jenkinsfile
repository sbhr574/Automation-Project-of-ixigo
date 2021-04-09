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
                script{
                            currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result

                }
  }
}
