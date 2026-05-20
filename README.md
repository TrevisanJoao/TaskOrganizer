# TaskOrganizer

A web-based task management application built with Java and Spring Boot. This project is being developed as a hands-on learning exercise, but is designed with production-grade architecture in mind — including containerization and Kubernetes deployment.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3.2.5 |
| Database | MySQL 8 |
| ORM | Spring Data JPA / Hibernate |
| Validation | Jakarta Validation |
| Boilerplate reduction | Lombok |
| Containerization | Docker *(planned)* |
| Orchestration | Kubernetes *(planned)* |

---

## Features

- Create, read, update and delete tasks
- Set task priority (LOW, MEDIUM, HIGH)
- Track task status (PENDING, IN_PROGRESS, DONE)
- Set due dates per task
- REST API with JSON responses

> User authentication and per-user task isolation are planned for a future phase.

---

## Project Structure

```
src/
└── main/
    ├── java/org/example/
    │   ├── TaskOrganizerApplication.java
    │   ├── controller/
    │   │   └── TaskController.java
    │   ├── service/
    │   │   └── TaskService.java
    │   ├── repository/
    │   │   └── TaskRepository.java
    │   ├── model/
    │   │   └── Task.java
    │   └── dto/
    │       └── TaskDTO.java
    └── resources/
        └── application.properties.example
```

---

## Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL 8

### Setup

**1. Clone the repository**
```bash
git clone <repository-url>
cd TaskOrganizer
```

**2. Create the database**
```sql
CREATE DATABASE tarefas_db;
```

**3. Configure the application**

Copy the example config file and fill in your credentials:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefas_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

**4. Run the application**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/tasks` | Create a task |
| `GET` | `/tasks` | List all tasks |
| `GET` | `/tasks/{id}` | Get task by ID |
| `PUT` | `/tasks/{id}` | Update a task |
| `DELETE` | `/tasks/{id}` | Delete a task |
| `PATCH` | `/tasks/{id}/status` | Update task status only |

### Example request — Create a task

```json
POST /tasks
Content-Type: application/json

{
  "titulo": "Study Spring Boot",
  "descricao": "Complete the REST API phase",
  "status": "PENDENTE",
  "prioridade": "ALTA",
  "dataVencimento": "2026-05-30"
}
```

---

## Roadmap

- [x] Project setup and dependencies
- [x] Database connection
- [x] Task entity and REST CRUD
- [ ] User authentication (JWT)
- [ ] Per-user task isolation
- [ ] Frontend (HTML + CSS + JavaScript)
- [ ] Docker packaging
- [ ] Kubernetes deployment

---

## License

This project is for educational purposes.
