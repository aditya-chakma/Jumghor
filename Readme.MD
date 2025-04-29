# Project jumghor

Experimental social media application

## Tech stack

Tech stack for this application

### Front end

- React
- Vanilla JS
- HTML
- CSS

### Backend

- Java 21
- Spring Boot
- Eureka
- Open Feign
- Spring Data JPA
- Spring Security

### Database

- PostgreSQL

### Orchestration

- Kubernetes
- Docker

## Environment Variables

Environment variable must be set for each of the microservices

## Microservices

Port range and description for microservices. The port ranges might change later based on the number of microservices

| Service                  | Description                                                                                              | Name                  | Port                      |
|--------------------------|----------------------------------------------------------------------------------------------------------|-----------------------|---------------------------|
| Eureka                   | Eureka is the netflix discovery server used to discover services based on their names. It works as a dns | eureka                | (default: 8761) 8700-8799 |
| Post and Comment Service | Serves Post and comment services. Supports CRUD operations for post and comments                         | post-comment-services | (default: 8221) 8200-8299 |
| Relation Service         | Serves contact request, add contact and follower/followee services.                                      | relation-service      | (default: 8379) 8300-8399 |
| User Service             | Serves CRUD operation for user services.                                                                 | user-service          | (default: 8100) 8100-8199 |
