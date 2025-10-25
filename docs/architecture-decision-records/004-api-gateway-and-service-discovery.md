🧩 ADR 004 — API Gateway & Service Discovery

Title: API Gateway and Service Discovery Approach
Date: 2025-10-25
Status: Proposed

Context

To route requests between services efficiently and support dynamic scaling, we need centralized routing and service registration.

Decision

Plan to introduce:

Spring Cloud Gateway for routing and rate limiting

Eureka Server (Netflix OSS) for service discovery

Consequences

✅ Simplifies client access
✅ Dynamic routing without hardcoding URLs
⚠️ Adds an extra service to manage
⚠️ Slight latency increase due to proxy layer