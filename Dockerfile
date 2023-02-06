FROM amazoncorretto:11-alpine-jdk 
MAINTAINER KNT
COPY target/knt-0.0.1-SNAPSHOT.jar knt-app.jar
ENTRYPOINT ["java","-jar","/knt-app.jar"]