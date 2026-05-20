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
- Set task priority (BAIXA, MEDIA, ALTA)
- Track task status (PENDENTE, EM_ANDAMENTO, CONCLUIDA)
- Set due dates per task
- REST API with JSON responses

> User authentication and per-user task isolation are planned for a future phase.

---

## Project Structure

```
src/
└── main/
    └── java/org/example/
        ├── TaskOrganizerApplication.java
        ├── model/
        │   └── Task.java
        ├── repository/
        │   └── TaskRepository.java
        ├── service/
        │   └── TaskService.java
        └── dto/
            └── TaskDTO.java
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

Create the file `src/main/resources/application.properties` with your credentials:

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

---

## Roadmap

- [x] Project setup and dependencies
- [x] Database connection (MySQL + HikariPool)
- [x] Task entity (model, DTO, repository, service)
- [ ] REST API controller
- [ ] User authentication (JWT)
- [ ] Per-user task isolation
- [ ] Frontend (HTML + CSS + JavaScript)
- [ ] Docker packaging
- [ ] Kubernetes deployment

---

## License

This project is for educational purposes.
