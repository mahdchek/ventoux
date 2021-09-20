node {
    stage("Checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '5224c92a-96b9-4562-aef1-09f07f734994', url: 'https://github.com/mahdchek/ventoux']]])
    }

    stage("build"){
        sh "chmod 777 -R ./ventoux/mvnw"
        sh "cd ventoux && ./mvnw clean install -DskipTests"
    }
}
