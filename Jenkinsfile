node('amazon') {
    stage("Checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '5224c92a-96b9-4562-aef1-09f07f734994', url: 'https://github.com/mahdchek/ventoux']]])
    }

    stage("build backend"){
        sh "chmod 777 -R ./ventoux/mvnw"
        sh "cd ventoux && ./mvnw clean install -DskipTests"
    }

    stage ("build front end") {
        sh "cd front && npm install && ng build --prod"
    }

    stage ("sonarqube"){
        sh "cd ventoux && ./mvnw  sonar:sonar \\\n" +
                "  -Dsonar.projectKey=ventoux \\\n" +
                "  -Dsonar.host.url=http://18.204.34.80:9011 \\\n" +
                "  -Dsonar.login=93d159940120470cf29ff8227abd37caa5fa1b9a"
    }

    try{
        sh "docker-compose down"
    }catch(Exception e){
        println "aucun conteneur n'est lancé"
    }

    stage ('Deploy application'){
        sh "sudo docker-compose up --build -d"
    }
}
