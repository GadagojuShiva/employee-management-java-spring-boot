# Stage 1: Build Stage
FROM adoptopenjdk/openjdk11:alpine as build

WORKDIR /opt/app

COPY . .

# Make the mvnw script executable
RUN chmod +x mvnw

# Run Maven without sudo
RUN ./mvnw clean package

# Stage 2: Runtime Stage
FROM adoptopenjdk/openjdk11:alpine-jre

ARG artifact=target/employee-management-system.jar

WORKDIR /opt/app

COPY --from=build /opt/app/${artifact} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
