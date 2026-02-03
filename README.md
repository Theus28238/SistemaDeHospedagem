# 🏨 Hosting Management System — Backend

Hosting Management System developed in **Java 17 with Spring Boot** as part of an **extracurricular academic project** from the  
**Analysis and Systems Development** course at **UNINASSAU (Faculdade Maurício de Nassau)**.

This repository represents the **backend** of the application, responsible for business logic, database persistence, and system integration.

---

## 🎓 Academic Context

- **Institution:** Faculdade Maurício de Nassau (UNINASSAU)  
- **Course:** Analysis and Systems Development  
- **Semester:** 2nd semester  
- **Academic Term:** 2025.2  
- **Subject:** Interdisciplinary Practical Extension Activity I  
- **Advisor:** None  

Project developed for educational purposes, with a strong focus on practical and real-world backend development.

---

## 💡 About the Project

The **Hosting Management System** is designed to manage guest and hosting data through a backend application built with **Spring Boot**.

This repository contains **only the backend** of the system.  
The **frontend was developed in a separate repository** using **HTML, CSS, and JavaScript**.

To run the system using the provided `.bat` file, **all frontend files must be placed inside the backend project**, within a directory under `src/main/resources`, allowing Spring Boot to serve the static content correctly.

The application is **not deployed** and runs locally for development and demonstration purposes.

---

## ⚙️ Implemented Features

✔️ Guest registration  
✔️ Guest data update  
✔️ Record deletion  
✔️ Hosting registration  
✔️ Full data persistence using database  
✔️ Backend–frontend integration  
✔️ Automated local execution via `.bat` file  

❌ Hosting cost calculation (not implemented)

---

## 🧱 Technologies Used

### Backend
- **Java 17**
- **Spring Boot**
- **Maven**
- **REST API**

### Database
- **PostgreSQL**
- Persistent storage (no in-memory data)

### Frontend
> Developed in a separate repository and later integrated
**Front-End:** https://github.com/pDiazz-dev/Front-Hospedagem

- HTML  
- CSS  
- JavaScript  

---

## 📂 Project Structure

Backend structure overview:
```
SistemaDeHospedagem/
├── .mvn/
├── pom.xml
├── run.bat
└── src/
└── main/
├── java/
│ └── (application packages)
└── resources/
├── application.yml
├── static/
│ └── (frontend files)
```
---

## ▶️ How to Run the Project

### Prerequisites

- Java JDK 17  
- Maven  
- PostgreSQL running and configured  
- IntelliJ IDEA (recommended)

---

### Running the Application

The application can be started in two ways:

#### 🔹 Option 1 — IntelliJ IDEA
- Open the project as a **Maven Project**
- Run the main Spring Boot application class

#### 🔹 Option 2 — Using the `.bat` File
- Place all frontend files inside `src/main/resources/static`
- Run the `run.bat` file
- The script will start the application automatically in IntelliJ

> Make sure the database credentials are correctly configured in `application.yml`.

---

## 🎯 Project Goals

- Apply **Object-Oriented Programming** concepts  
- Develop a real backend application using **Spring Boot**  
- Integrate frontend and backend  
- Work with a **relational database**  
- Simulate a professional software development scenario  

---

## 🚀 Possible Future Improvements

- Hosting cost calculation  
- User authentication and authorization  
- Cloud deployment  
- API documentation with Swagger/OpenAPI  
- Automated tests  
- Improved validations  

---

## 👥 Authors

- **Matheus Guilherme**  
  GitHub: https://github.com/Theus28238  

- **pDiazz-dev**  
  GitHub: https://github.com/pDiazz-dev  

---

## 📄 License

This project is intended for **educational and portfolio purposes**, free to use for study and reference.

