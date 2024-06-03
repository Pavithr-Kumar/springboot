FROM openjdk:17-slim

MAINTAINER zettamine.com

COPY target/sb-docker.jar docker.jar

ENTRYPOINT [ "java", "-jar", "docker.jar" ]