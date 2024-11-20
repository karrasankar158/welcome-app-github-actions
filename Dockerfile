#Base Image with OpenJDK 21
FROM openjdk:21-jdk-slim

#Set the Application Directory
WORKDIR /app

#Copy the Application JAR
COPY target/*.jar welcome-app-0.0.1-SNAPSHOT.jar

#Expose Application port
EXPOSE 8080

#Execute the application
ENTRYPOINT ["java","-jar","welcome-app-0.0.1-SNAPSHOT.jar"]
