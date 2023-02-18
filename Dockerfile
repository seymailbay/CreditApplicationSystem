FROM openjdk:18-jdk-alpine
COPY target/SpringMP-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
