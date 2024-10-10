# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the WAR file into the container
COPY target/angularassignment-0.0.1-SNAPSHOT.war app.war

# Expose the port the app runs on
EXPOSE 9000

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.war"]
