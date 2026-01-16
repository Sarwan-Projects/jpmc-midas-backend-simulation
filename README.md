# [Job Simulation] JPMorgan Chase & Co. Software Engineering - Midas Core

[![Certificate](https://img.shields.io/badge/Certification-View%20on%20Forage-blue)](https://www.theforage.com/completion-certificates/Sj7temL583QAYpHXD/E6McHJDKsQYh79moz_Sj7temL583QAYpHXD_P8BpSQx8zKM4BovnC_1768564501431_completion_certificate.pdf)

## 📌 Project Overview
This repository contains my implementation of the **Midas Core** backend system completed as part of the **JPMorgan Chase & Co. Software Engineering Job Simulation** on Forage.

**Note:** This is a professional simulation project designed to replicate real-world engineering tasks at JPMC. It is not an open-source contribution to official JPMC production code.

### 📜 Official Certification
I have officially completed this simulation. You can verify my credentials here:
**[View My Verified Certificate](https://www.theforage.com/completion-certificates/Sj7temL583QAYpHXD/E6McHJDKsQYh79moz_Sj7temL583QAYpHXD_P8BpSQx8zKM4BovnC_1768564501431_completion_certificate.pdf)**

---

## 🛠️ Key Technical Implementations
In this simulation, I functioned as a Backend Engineer to build a high-volume transaction processing microservice:

### 1. Event-Driven Architecture (Apache Kafka)
- Configured a **Kafka Consumer** within Spring Boot to ingest high-volume transaction messages.
- Implemented custom deserialization logic to handle incoming JSON payloads from the `transactions` topic.
- Utilized an embedded Kafka framework for robust integration testing.

### 2. Data Persistence & Validation (Spring Data JPA)
- Developed a relational data model using **H2 Database** to track user balances.
- Implemented atomic balance updates and transaction validation logic to ensure data integrity.

### 3. External API Integration (REST)
- Integrated the service with an external **REST Incentive API** using `RestTemplate`.
- Processed external API responses to dynamically apply transaction incentives.

### 4. Quality Assurance
- Achieved full test coverage using **Maven** and **JUnit**, ensuring the reliability of message ingestion, database persistence, and API communication.

---

## 🚀 Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot
- **Messaging:** Apache Kafka
- **Database:** H2 (SQL) / Spring Data JPA
- **Build Tool:** Maven

---

## 📂 Project Structure
- `src/main/java`: Backend logic, Kafka consumers, and REST controllers.
- `src/test/java`: Integration and unit test suites.
- `pom.xml`: Dependency management and build configuration.

---
*Disclaimer: This project was completed as part of the JPMorgan Chase & Co. Job Simulation via Forage.*