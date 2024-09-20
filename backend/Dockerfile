FROM gradle:8.10.1-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon

FROM amazoncorretto:17-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
