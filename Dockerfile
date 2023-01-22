FROM openjdk:17-jdk-slim


RUN apk add maven
RUN mvn clean install -DskipTests

COPY target/springmongoconnect-0.0.1-SNAPSHOT.jar app.jar 

EXPOSE 8080 

ENTRYPOINT ["java", "-jar", "/app.jar"] 