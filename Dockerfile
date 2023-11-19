FROM gradle:8.2.1-jdk17 AS build

COPY . /review-web-service

WORKDIR /review-web-service

RUN gradle clean build

FROM openjdk:17

COPY --from=build /review-web-service/build/libs/review-service-0.0.1-SNAPSHOT.jar /app/review-web-service.jar

WORKDIR /app

CMD ["java", "-jar", "review-web-service.jar"]