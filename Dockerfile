## docker network create pg_network
## docker build -f Dockerfile -t mentorize-local .
## docker run -d --network pg_network -p 5432:5432 -v $(pwd):/mentorize/ mentorize
#FROM postgres:latest
#
#ENV POSTGRES_DB mentorize
#ENV POSTGRES_USER postgres
#ENV POSTGRES_PASSWORD postgres
#
#COPY init.sql /docker-entrypoint-initdb.d/
#
#EXPOSE 5432

# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Create a lightweight image with the JAR file
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
