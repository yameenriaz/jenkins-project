pipeline {
  agent none  
  options {
    buildDiscarder(logRotator(numToKeepStr: '2', artifactNumToKeepStr: '1'))
  }
  stages {
    stage('Unit Tests') {
      agent {
        label 'Master'
      }
      steps {
        sh 'ant -f test.xml -v'
        junit 'reports/result.xml'
      }
    }
    stage('build') {
      agent {
        label 'Master'
      }
      steps {
        sh 'ant -f build.xml -v'
      }
      post {
        success {
          archiveArtifacts artifacts: 'dist/*.jar', fingerprint: true
        }
      }  
    }
    stage('Deploy') {
      agent {
        label 'Master'
      }
      steps {
        sh "cp dist/rectangle_${env.BUILD_NUMBER}.jar /var/www/html/rectangles/all/"        
      }
    }
    stage('Running on Centos') {
      agent {
        label 'CentOS'
      }
      steps {
        sh "wget http://192.168.1.100/rectangles/all/rectangle_${env.BUILD_NUMBER}.jar"
        sh "java -jar rectangle_${env.BUILD_NUMBER}.jar 3 4 "
      }
    }
  }
}
