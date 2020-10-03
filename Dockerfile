FROM openjdk:11-jdk-slim

WORKDIR app
COPY target/substitution-service-java-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]