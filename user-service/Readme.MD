# User service

User CRUD services.

## Server Configuration

| app-name     | current-version | url-prefix | port | port-range  | server-id |
|--------------|-----------------|------------|------|-------------|-----------|
| user-service | 0.0.1-SNAPSHOT  | /v1/u      | 8100 | 8100 - 8199 | 100       |

## Dependencies

**Maven dependencies**

- Spring Boot Starter (Web + Validation + Test)
- Spring Data JPA
- Postgresql
- Eureka client
- Actuator

**Module dependencies**

- iAxis.jumghor.entities
- iAxis.jumghor.utils

## Commands

Change server port with `-Dserver.port=8100 -Dserver.id=100`. Change server Ids for each deployment within the approved
port ranges. Which might change later.