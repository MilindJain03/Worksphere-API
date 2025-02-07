# WorkSphere

A web-based Employee Management System (EMS) that enables administrators to perform CRUD (Create, Read, Update, Delete) operations on employee records. The system includes authentication and authorization features and is built using React Vite for the frontend, Java Spring Boot for the backend, and PostgreSQL for the database.

## Features

- **Authentication & Authorization:** Secure login, logout, and user registration features.
- **CRUD Operations:** Create, read, update, and delete employee records.
- **Responsive UI:** Designed for a smooth user experience across different devices.
- **Real-Time Validations:** Form validation to ensure accurate data input.


## Installation

### Prerequisites

- Node.js (v14 or later)
- Java 11+
- PostgreSQL

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/MilindJain03/Worksphere-API.git
   ```
2. Navigate to the backend directory:
   ```bash
   cd project-root/backend
   ```
3. Set up your PostgreSQL database:
   ```sql
   CREATE DATABASE employee_management;
   ```
4. Update the database credentials in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/employee_management
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```
5. Run the backend:
   ```bash
   ./gradlew bootRun
   ```

## API Endpoints

| Endpoint             | Method | Description                        |
|----------------------|--------|------------------------------------|
| `/auth/register`     | POST   | Register a new user                |
| `/auth/login`        | POST   | Log in a user                      |
| `/employees`         | GET    | Get a list of all employees        |
| `/employees/{id}`    | GET    | Get details of a specific employee |
| `/employees`         | POST   | Create a new employee              |
| `/employees/{id}`    | PUT    | Update an existing employee        |
| `/employees/{id}`    | DELETE | Delete an employee                 |
