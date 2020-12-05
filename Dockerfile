# Start with a base image containing Java runtime
FROM openjdk:11-jdk-alpine

LABEL maintainer="mamaamar1993@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/test-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} bizao-test.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bizao-test.jar"]