# 🏗️ Tradeflow
_A Spring Boot Microservice-Based Trade and Order Management Platform_

---

## 🔁 Data Flow Overview

1. **Product Service** registers products.
2. **Order Service** creates orders and checks product availability via **Inventory Service**.
3. **Inventory Service** validates stock levels and returns a boolean response.
4. **Notification Service** (via Kafka) broadcasts order and inventory events for analytics and communication.

---

## 🧱 Technologies Used

| Category | Technologies |
|-----------|---------------|
| **Language** | Java 17+ |
| **Frameworks** | Spring Boot 3+, Spring Data JPA, Lombok |
| **Architecture** | Microservices, REST, Event-Driven (Kafka-ready) |
| **Build Tool** | Maven (multi-module project) |
| **Database** | H2 / MySQL |
| **Cloud & DevOps** | OpenShift / Docker / CI-CD pipelines (GitHub Actions / Jenkins) |
| **Optional Expansion** | Spring Cloud (Config Server, Eureka, Gateway, Sleuth) |

---

## 🧩 Architecture Decision Records (ADRs)

**Purpose:**  
ADRs capture **key architectural and technical decisions** made throughout the Tradeflow platform lifecycle — ensuring decisions are **documented, reviewed, and traceable**.

---

### 🧭 ADR Format

Each ADR follows this structure:

| Field | Description |
|--------|--------------|
| **Title** | Short, descriptive summary of the decision |
| **Date** | When the decision was made |
| **Status** | Accepted / Proposed / Deprecated |
| **Context** | Why the decision was necessary |
| **Decision** | What was decided and how it’s implemented |
| **Consequences** | Benefits, trade-offs, and impact on the system |

---

### 🪜 ADR Workflow

1. Create a new ADR file in `/docs/architecture/adr/`  
   Example: `006-new-decision.md`
2. Describe the rationale and alternatives considered.
3. Submit a pull request for peer review.
4. Once approved, mark it as **“✅ Accepted”**.
5. Keep deprecated or revised decisions for historical traceability.

---

## 📜 ADR Index

| ADR ID | Decision | Status |
|:-------:|:----------|:--------:|
| 001 | Architecture Style | ✅ Accepted |
| 002 | Database Strategy | ✅ Accepted |
| 003 | Inter-Service Communication (REST + Kafka) | ✅ Accepted |
| 004 | API Gateway & Service Discovery | 🕓 Proposed |
| 005 | Deployment Strategy (Docker & OpenShift) | ✅ Accepted |
| 006 | Observability & Monitoring (Micrometer + Prometheus) | 🕓 Planned |
| 007 | Security & Authentication (Keycloak / OAuth2) | 🕓 Planned |

---

## 🧰 Folder Structure

