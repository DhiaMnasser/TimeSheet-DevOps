FROM openjdk:8
EXPOSE 8083
ADD /target/TimeSheet-1.4.jar TimeSheet-1.4.jar
ENTRYPOINT ["java","-jar","TimeSheet-1.4.jar"]