FROM openjdk:8
EXPOSE 8085
ADD /target/timesheet-1.1.4-SNAPSHOT.jar timesheet-1.1.4-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","timesheet-1.1.4-SNAPSHOT.jar"]