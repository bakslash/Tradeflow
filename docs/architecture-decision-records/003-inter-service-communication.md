# 🧩 ADR 003 — Inter-Service Communication

**Title:** RESTful and Event-Driven Communication Between Services  
**Date:** 2025-10-25  
**Status:** Accepted

---

## 🧠 Context

Services in the platform need to exchange data and coordinate actions.  
For example:
- **Order Service** needs to check **Inventory Service** before creating an order.
- **Notification Service** needs to be informed when an order is created or updated.

Previously, all communication was handled synchronously using REST APIs.  
While this is simple and easy to debug, it introduces latency, tight coupling, and potential cascading failures under high load.

To enhance **scalability**, **resilience**, and **asynchronous processing**, an additional **event-driven communication mechanism** is introduced using **Apache Kafka**.

---

## ⚙️ Decision

Adopt a **hybrid communication strategy**:
- **Synchronous Communication:** Use **REST over HTTP** with **Spring WebClient** for direct, request-response interactions (e.g., fetching inventory data or validating user details).
- **Asynchronous Communication:** Use **Apache Kafka** for event-driven interactions (e.g., notifying other services of completed orders, sending email/SMS notifications, updating analytics).

This dual approach allows services to choose the communication mode that best fits their use case.

---

## 🧩 Implementation Summary

| Communication Type | Use Case Example | Technology | Description |
|--------------------|------------------|-------------|--------------|
| **Synchronous (Request/Response)** | Order → Inventory check | REST (Spring WebClient) | Direct service call requiring immediate response |
| **Asynchronous (Event-Driven)** | Order → Notification or Analytics | Kafka | Publish domain events for decoupled, background processing |

---

## 🧱 Example Integration

### **REST (Synchronous)**

```java
WebClient webClient = WebClient.create("http://inventory-service/api");

InventoryResponse response = webClient.get()
    .uri("/inventory/{id}", productId)
    .retrieve()
    .bodyToMono(InventoryResponse.class)
    .block();
