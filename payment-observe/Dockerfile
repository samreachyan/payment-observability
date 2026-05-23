FROM curlimages/curl:8.13.0 AS download

ARG OTEL_AGENT_VERSION="2.16.0"

RUN curl --silent --fail --insecure -L \
  "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OTEL_AGENT_VERSION}/opentelemetry-javaagent.jar" \
  -o /tmp/opentelemetry-javaagent.jar


FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/payment-observe-0.0.1-SNAPSHOT.jar payment-service.jar
COPY --from=download /tmp/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

EXPOSE 8080

ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/payment-service.jar"]