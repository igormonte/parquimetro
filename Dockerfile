FROM openjdk:17-jdk-slim
LABEL authors="igor.monte"

RUN mkdir /var/app
COPY ./target/*.jar /var/app/app.jar

WORKDIR /var/app/

ENTRYPOINT ["java", "-jar", "app.jar"]