🧩 ADR 002 — Database Strategy

Title: Database per Service
Date: 2025-10-25
Status: Accepted

Context

Each service manages its own data domain (Product, Order, Inventory). Sharing a single database would tightly couple services.

Decision

Each microservice has its own database schema:

ProductService → product_db

OrderService → order_db

InventoryService → inventory_db

Consequences

✅ Loose coupling, independent data models
✅ Enables polyglot persistence (different DBs if needed)
⚠️ Requires eventual consistency between services (no joins across DBs)