FROM openjdk:17-jdk-alpine

LABEL name="BookPlace"
LABEL description="API - BookPlace e-commerce"
LABEL maintainer="frank-destro@outlook.com"

RUN addgroup -S bookPlace-group && adduser -S bookPlace-user -G bookPlace-group

USER bookPlace-user:bookPlace-group

ADD ./target/BookPlace-0.0.1-SNAPSHOT.jar bookPlace.jar

EXPOSE 8080

