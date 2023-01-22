# Use the OpenJDK 17 image as the base image
FROM openjdk:17

# Expose port 8080
EXPOSE 8080

# Add the jar file to the container
ADD target/spring-boot-docker.jar spring-boot-docker.jar 

# Set the entry point to run the jar file
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
