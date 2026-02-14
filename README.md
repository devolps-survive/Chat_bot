## 🤖 AI Chatbot

AI Chatbot is a full-stack web-based chatbot application that allows users to register, log in, and interact with an AI-powered conversational system. The application is built using Spring Boot (Java) for the backend, HTML, CSS, and JavaScript for the frontend, and PostgreSQL as the database (chatbot_db). Docker support is included for easy deployment and environment setup.

## 🚀 Features

- User Registration and Login (Authentication with JWT)

- AI-powered chat interaction

- Chat message storage in PostgreSQL

- Knowledge page and landing page

- Responsive frontend design

- Dockerized setup for backend, frontend, and database

## 🏗️ Project Structure
    ai_chatbot/
    │
    ├── backend/        # Spring Boot application
    ├── frontend/       # HTML, CSS, JavaScript frontend
    ├── db/             # Database scripts (init.sql, seed.sql)
    ├── docker/         # Dockerfiles and docker-compose
    ├── README.md
    └── .gitignore

## 🛠️ Technologies Used
** Backend **

 - Java

 - Spring Boot

 - Spring Security

 - JWT Authentication

 - Maven

** Frontend **

  - HTML5

  - CSS3

  - JavaScript (Fetch API)

**Database**

  - PostgreSQL (chatbot_db)

  - DevOps

  - Docker

  - Docker Compose

## ⚙️ Database Configuration

 - Database name:

    chatbot_db


        Example configuration in application.properties:
        
        spring.datasource.url=jdbc:postgresql://localhost:5432/chatbot_db
        spring.datasource.username=postgres
        spring.datasource.password=yourpassword

## ▶️ How to Run the Project
**Option 1: Run Manually**

  - Start PostgreSQL and create the database:

  - CREATE DATABASE chatbot_db;


  - Run the backend:

  - Open the backend in Eclipse

  - Run BackendApplication.java as a Java application

  - Open frontend:

  - Open landing.html or login.html in your browser

  - Backend runs on:

        http://localhost:8080

** Option 2: Run with Docker **

## From the docker folder:

      docker-compose up --build


## Services:

  - Frontend → http://localhost:3000

  - Backend → http://localhost:8080

  - PostgreSQL → Port 5432

## 🔄 Application Flow
    User → Frontend → Spring Boot Backend → PostgreSQL
                                       ↓
                                     AI API

## 🔐 Authentication

  The application uses JWT-based authentication. After login, a token is generated and stored in the browser. All protected routes require a valid JWT token.

## 📌 Future Improvements

  - Role-based access control

  - Chat history UI improvements

  - Admin dashboard

Deployment to cloud (AWS / Azure / Render)

WebSocket real-time chat

## 👨‍💻 Author

Developed as a full-stack chatbot project using Java, Spring Boot, PostgreSQL, and Docker.
