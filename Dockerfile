FROM maven:3.8.3-jdk-17 AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /target/springmongoconnect-0.0.1-SNAPSHOT.jar /app/demo.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/demo.jar"]