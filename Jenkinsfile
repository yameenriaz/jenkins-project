pipeline {
  agent any
  
  options {
    buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '1'))
  }
  stages {
    stage('build') {
      steps {
        sh 'ant -f build.xml -v'
      }
    }
    stage('Test') {
      steps {
        echo "Testing stage run"
      }
    }
    stage('Deploy') {
      steps {
        echo "Deploy stage run"
      }
    }
  }
  
  post {
    always {
       archiveArtifacts artifacts: 'dist/*.jar', fingerprint: true
    }
  }
}
