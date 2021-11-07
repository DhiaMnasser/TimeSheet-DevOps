FROM openjdk:8
EXPOSE 8083
ADD /target/TimeSheet-1.0.1-SNAPSHOT.jar TimeSheet-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","TimeSheet-1.0.1-SNAPSHOT.jar"]