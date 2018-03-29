pipeline {
  agent any

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
       archiveArtifacts artifacts: "dist/*-$BUILD_NUMBER.jar", fingerprint: true
    }
  }
}
