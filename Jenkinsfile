pipeline {
  agent any
  
  options {
    buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '1'))
  }
  stages {
    stage('Unit Tests') {
      steps {
        sh 'ant -f text.xml -v'
        junit 'reports/reslt.xml'
      }
    }
    stage('build') {
      steps {
        sh 'ant -f build.xml -v'
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
