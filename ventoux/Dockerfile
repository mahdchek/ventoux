FROM ubuntu
MAINTAINER Mahdi CHEKINI <me.chekini@gmail.com>
RUN apt-get update && apt-get install openjdk-11-jdk vim curl -y
WORKDIR /opt
ADD target/ventoux-*.jar ventoux.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/ventoux.jar"]
