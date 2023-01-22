# Build stage
#
FROM openjdk:17-jdk-alpine AS build

RUN apk add maven

COPY . .
RUN mvn clean install -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-alpine
COPY --from=build /target/springmongoconnect-0.0.1-SNAPSHOT demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
