# Stage 1: Build Stage

# Use the adoptopenjdk/openjdk11:alpine-jre as the base image
FROM adoptopenjdk/openjdk11:alpine-jre

# Define an argument 'artifact' with a default value pointing to the JAR file in the 'target' directory
ARG artifact=target/employee-management-0.0.1-SNAPSHOT.jar

# Set the working directory inside the container to /opt/app
WORKDIR /opt/app

# Copy the JAR file specified by the 'artifact' argument from the build context to the /opt/app directory in the container
COPY ${artifact} app.jar

# Specify the entry point for the container as running the Java application using the 'java -jar app.jar' command
ENTRYPOINT ["java", "-jar", "app.jar"]
