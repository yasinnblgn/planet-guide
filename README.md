# Planet Guide 🌍

## Project Overview
**Planet Guide** is a Spring Boot-based CRUD application that allows users to manage planet information. The application enables users to:
- Add, view, edit, and delete planets.
- Store information such as name, mass, diameter, number of moons, and description.

This project is a practical example of using Spring Boot for RESTful APIs integrated with a simple frontend.

---

## Features
- **Backend**:
  - Spring Boot with RESTful APIs.
  - CRUD operations for planets.
  - H2 In-Memory Database.
  - CORS-enabled for frontend integration.

- **Frontend**:
  - HTML + Bootstrap for responsive UI.
  - Vanilla JavaScript for dynamic interactivity.

---

## Technologies Used
- **Backend**: Spring Boot, Spring Data JPA, H2 Database.
- **Frontend**: HTML, Bootstrap, JavaScript.

---

2- Run the Spring Boot application:

./mvnw spring-boot:run

Open WebContent/index.html in your browser to use the app.

---

API Endpoints
GET /api/planets - Fetch all planets.
POST /api/planets - Add a new planet.
PUT /api/planets/{id} - Update an existing planet.
DELETE /api/planets/{id} - Delete a planet.

---

Project Structure

src/main/java
├── entity           # Planet entity class
├── repository       # JPA repository interface
├── service          # Business logic layer
└── controller       # RESTful API controller


---
TÜRKÇE


