# Engine Monitoring System

A Spring Boot backend application that simulates engine sensor data,
processes it asynchronously using multithreading, stores it in PostgreSQL,
and exposes REST APIs to fetch engine metrics and alerts.

---

## 🚀 Features

- Simulates engine sensor data (temperature, pressure, RPM)
- Asynchronous data processing using BlockingQueue and ExecutorService
- Stores engine data and alerts in PostgreSQL
- REST APIs to fetch engine metrics and alerts
- Multithreaded backend design

---

## 🧠 System Architecture

Sensor Simulator  
→ BlockingQueue  
→ Worker Threads (ExecutorService)  
→ Database (PostgreSQL)  
→ REST APIs  

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Multithreading (ExecutorService, BlockingQueue)

---

## 📁 Project Structure

```text
src/main/java/com/engine
 ├── controller   → REST API controllers
 ├── model        → JPA entities
 ├── repository   → Database access layer
 ├── simulator    → Sensor data generator
 ├── config       → Thread & queue configuration
 └── service      → Business logic
