# UserManagementAPI-JPA

This project is a simple User Management REST API built using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**.

It supports basic CRUD operations on users like create, fetch, update, and delete.

## 🔧 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit, Mockito (for testing)

## 📌 Features Implemented

- Add a new user
- Get all users
- Get user by ID
- Update user
- Delete user by ID
- Unit testing using Mockito and JUnit

📬 API Endpoints
| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| POST   | `/api/users`      | Create new user |
| GET    | `/api/users`      | Get all users   |
| GET    | `/api/users/{id}` | Get user by ID  |
| PUT    | `/api/users/{id}` | Update user     |
| DELETE | `/api/users/{id}` | Delete user     |

🧪 Testing
Unit tests are written using JUnit and Mockito.
Sample test: UserControllerTest.java using MockMvc.

📁 Project Structure
user-management-JPA/
├── src/                                 # Source folder
│   ├── main/                            # Main application code
│   │   ├── java/
│   │   │   └── com/example/UserManagementAPI/
│   │   │       ├── controller/          # Contains REST controllers (e.g., UserController.java)
│   │   │       ├── entity/              # Contains JPA entity classes (e.g., User.java)
│   │   │       ├── repository/          # Contains interfaces that extend JpaRepository
│   │   │       └── service/             # Contains service classes for business logic
│   │   └── resources/
│   │       └── application.properties   # Configuration file for DB and Spring Boot setup
│
│   └── test/                            # Test source code
│       └── java/
│           └── com/example/UserManagementAPI/
│               └── controller/          # Contains test classes (e.g., UserControllerTest.java)
│
├── .gitignore                      
├── pom.xml                              
├── README.md                            




