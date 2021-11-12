FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD /target/timesheet-1.0.4-SNAPSHOT.jar timesheet-1.0.4-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","timesheet-1.0.4-SNAPSHOT.jar"]