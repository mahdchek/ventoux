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

    try{
        sh "docker-compose down"
    }catch(Exception e){
        println "aucun conteneur n'est lancé"
    }

    stage ('Deploy application'){
        sh "sudo docker-compose up --build -d"
    }
}
