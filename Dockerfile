FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN apk add maven
RUN mvn clean install -DskipTests
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]