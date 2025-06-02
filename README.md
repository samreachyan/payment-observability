# Payment Observability Platform

A comprehensive payment processing system with built-in observability using modern monitoring and tracing tools.

## 🚀 Technologies

### Core Application
- **Spring Boot 3.x**: Backend framework
- **Java 17+**: Programming language
- **PostgreSQL**: Primary database
- **Spring Data JPA**: Database access
- **Spring Web**: REST API endpoints
- **Spring Boot Actuator**: Application metrics and health checks

### Observability Stack
- **Grafana**: Visualization and dashboards
- **Prometheus**: Metrics collection and storage
- **Loki**: Log aggregation
- **Tempo**: Distributed tracing
- **OpenTelemetry**: Instrumentation
- **Zipkin**: Alternative tracing (for compatibility)

## 🏗️ Project Structure

```
Payment-Observability/
├── deployments/                # Docker and configuration files
│   ├── docker-compose.yml     # Main Docker Compose file
│   ├── grafana/               # Grafana configurations
│   │   ├── dashboards/        # Pre-configured dashboards
│   │   └── datasources/       # Data source configurations
│   ├── loki/                  # Loki configurations
│   ├── prometheus/            # Prometheus configuration
│   └── tempo/                 # Tempo tracing configuration
└── payment-observe/           # Spring Boot application
    ├── src/
    │   └── main/
    │       ├── java/com/sakcode/paymentobserve/
    │       │   ├── controller/  # REST controllers
    │       │   ├── domain/      # JPA entities
    │       │   ├── dto/         # Data Transfer Objects
    │       │   ├── repository/  # Data access layer
    │       │   ├── service/     # Business logic
    │       │   └── PaymentObserveApplication.java
    │       └── resources/
    │           ├── application.yml  # Application configuration
    │           └── logback-spring.xml  # Logging configuration
    └── pom.xml                 # Maven dependencies
```

## 🛠️ Architecture & Integration

### 1. Application Architecture

The application follows a standard Spring Boot layered architecture:
- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Manages data access
- **Domain Layer**: Defines data models

### 2. Observability Integration

#### Metrics Collection
- **Prometheus** scrapes metrics from Spring Boot Actuator endpoints
- Metrics include JVM, HTTP requests, database connections, and custom business metrics
- Scraping interval: 15 seconds (configurable in Prometheus)

#### Logging
- **Loki** collects and indexes logs
- **Promtail** ships logs from the application to Loki
- Logs are labeled with service name, environment, and log level
- Log retention: 7 days (configurable)

#### Distributed Tracing
- **Tempo** receives traces from the application
- **OpenTelemetry** instrumentation automatically creates traces for:
  - HTTP requests
  - Database queries
  - Message processing
- **Zipkin** is included for backward compatibility

#### Visualization
- **Grafana** provides dashboards for:
  - System metrics (CPU, memory, threads)
  - Application metrics (request rates, error rates)
  - Business metrics (payment processing stats)
  - Log exploration via Loki
  - Distributed traces visualization

## 🚀 Deployment

### Prerequisites
- Docker 20.10+
- Docker Compose 2.0+
- Java 17+
- Maven 3.8+

### Running with Docker Compose

1. Start the infrastructure:
   ```bash
   cd deployments
   docker-compose up -d
   ```

2. Build and run the Spring Boot application:
   ```bash
   cd payment-observe
   mvn spring-boot:run
   ```

### Accessing Services

- **Application**: http://localhost:8080
- **Grafana**: http://localhost:3000 (admin/admin default credentials)
- **Prometheus**: http://localhost:9090
- **Loki**: http://localhost:3100
- **Tempo**: http://localhost:3200
- **Zipkin**: http://localhost:9411

## 📊 Monitoring & Alerts

### Pre-configured Dashboards

1. **Application Overview**
   - Request rates and latencies
   - Error rates and types
   - JVM metrics
   - Database connection pool

2. **Payment Processing**
   - Payment success/failure rates
   - Processing times
   - Transaction volumes

3. **Infrastructure**
   - Container resources
   - Network I/O
   - Storage usage

### Alerting
Alerts are configured in Grafana and can be sent to:
- Email
- Slack
- PagerDuty
- Webhooks

## 🔧 Configuration

### Application Configuration (`application.yml`)

```yaml
server:
  port: 8080

spring:
  application:
    name: payment-observe
  datasource:
    url: jdbc:postgresql://localhost:5432/paymentdb
    username: user
    password: pass

management:
  endpoints:
    web:
      exposure:
        include: "*"
  tracing:
    sampling:
      probability: 1.0
```

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | Database URL | `jdbc:postgresql://postgres:5432/paymentdb` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `user` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `pass` |
| `OTEL_EXPORTER_OTLP_ENDPOINT` | OpenTelemetry collector endpoint | `http://tempo:4318` |
| `LOGGING_LEVEL_ROOT` | Root logging level | `INFO` |

## 🔄 Development

### Building the Application
```bash
mvn clean package
```

### Running Tests
```bash
mvn test
```

### Code Style
- Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Use 4 spaces for indentation
- Maximum line length: 120 characters

## 📚 Documentation

- [API Documentation](http://localhost:8080/swagger-ui.html) (when enabled)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Grafana Documentation](https://grafana.com/docs/)
- [Prometheus Documentation](https://prometheus.io/docs/)
- [Loki Documentation](https://grafana.com/docs/loki/latest/)
- [Tempo Documentation](https://grafana.com/docs/tempo/latest/)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## ✨ Contributors

- [Samreach Yan](https://github.com/samreachyan)

---

Made with ❤️ using Spring Boot and the Grafana Observability Stack
