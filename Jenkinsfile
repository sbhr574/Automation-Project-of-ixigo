pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      input {
        message 'Should we continue?'
        id 'Yes, we should.'
        submitter 'me, my job'
      }
        parameters {
          string(name: 'ENGINEER', defaultValue: 'Mr. Subhajit', description: 'Hello All...')
        }
      steps {
        echo 'Git repo checkout operation ${params.ENGINEER}'
      }
  }

    stage('Build') {
      when {
        branch 'master'
      }
      steps {
        echo 'Started Clean and Build Process.'
        bat 'mvn clean install -DskipTests'
      }
    }

    stage('Test') {
      steps {
        echo 'Started test execution.'
        bat 'mvn test -Dsurefire.suiteXmlFiles=testNg.xml'
      }
    }

    stage('Example') {
      steps {
        echo "Hello ${params.PERSON}"
        echo "Biography: ${params.BIOGRAPHY}"
        echo "Toggle: ${params.TOGGLE}"
        echo "Choice: ${params.CHOICE}"
        echo "Password: ${params.PASSWORD}"
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
  parameters {
    string(name: 'PERSON', defaultValue: 'Mr Subhajit', description: 'Who should I say hello to?')
    text(name: 'BIOGRAPHY', defaultValue: 'QA Automation', description: 'Enter some information about the person')
    booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
    choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
    password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
  }
}