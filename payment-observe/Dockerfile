FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/payment-observe-0.0.1-SNAPSHOT.jar /app/payment-service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/payment-service.jar"]