# 📧 E-mail Microservice - SendGift
This microservice is responsible for sending email notifications related to the core functionality of the SendGift application, enabling automatic communication for users who send or receive gifts. It's part of a personal [study project](https://github.com/bragabriel/project-sendgift) focused on applying intermediate-to-advanced concepts and tools in API and microservices development.

## ✨ Functionality
When a user sends a gift, they receive a confirmation email stating that the gift was successfully delivered to the recipient.
When a user receives a gift, they get an email notification including the sending date and the sender's name.

## 🧩 Architecture
This service follows the Hexagonal Architecture (Ports & Adapters) principles, promoting a clear separation between business logic and infrastructure (e.g., the email provider). This separation improves testing, maintainability, and scalability.

Additional tools and approaches used:

- OpenFeign for inter-service communication.
- Amazon Simple Email Service (AWS SES) for reliable email delivery.

## ⚙️ Technologies & Tools
- Java 21
- Spring Boot 3.2
- Spring Cloud / OpenFeign
- Hexagonal Architecture
- AWS SES (Simple Email Service)
- Unit testing with JUnit and Mockito

## 📬 Integrations
This microservice is consumed by the main SendGift application, which triggers the email sending logic upon gift-related events.

## 🧪 Testing
Unit tests with JUnit and Mockito, including mocks for external calls (AWS SES and Feign).
