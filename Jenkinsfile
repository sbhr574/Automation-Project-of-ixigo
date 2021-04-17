pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      steps {
        echo 'Git repo checkout operation'
      }
    }

    stage('Build') {
      steps {
        bat 'mvn clean package'
      }
    }

  }
  environment {
    maven = '${MVN_HOME}'
    jdk = '${JAVA_HOME}'
  }
  post {
    success {
      script {
        currentBuild.result = 'SUCCESS'
        currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result
      }

    }

    failure {
      script {
        currentBuild.result = 'FAILED'
        currentBuild.displayName = "Declarative_Pipeline_#"+currentBuild.result
        buildDescription("Committer: ${GERRIT_PATCHSET_UPLOADER_NAME}")
      }

    }

  }
}