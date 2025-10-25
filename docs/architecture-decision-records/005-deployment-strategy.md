🧩 ADR 005 — Deployment Strategy

Title: Containerized Deployment with Docker
Date: 2025-10-25
Status: Accepted

Context

To maintain consistency across environments and simplify deployment automation, we need containerized builds.

Decision

Use Docker for all services.
Each service will have its own Dockerfile, built and pushed via CI/CD pipelines.

Example Dockerfile snippet:

FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

Consequences

✅ Easy portability
✅ Enables cloud-native scaling (Kubernetes ready)
⚠️ Slightly increased image management overhead