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

| Service                  | ID  | Description                                                                                              | Name                  | Port                      |
|--------------------------|-----|----------------------------------------------------------------------------------------------------------|-----------------------|---------------------------|
| Eureka                   | 761 | Eureka is the netflix discovery server used to discover services based on their names. It works as a dns | eureka                | (default: 8761) 8700-8799 |
| Post and Comment Service | 221 | Serves Post and comment services. Supports CRUD operations for post and comments                         | post-comment-services | (default: 8221) 8200-8299 |
| Relation Service         | 379 | Serves contact request, add contact and follower/followee services.                                      | relation-service      | (default: 8379) 8300-8399 |
| User Service             | 100 | Serves CRUD operation for user services.                                                                 | user-service          | (default: 8100) 8100-8199 |
| Config Server            | 888 | Config server provides configurations to it's clients. Config server centralizes the configurations      | config-server         | (default: 8888) 8800-8899 |

## Modules

The core components are divided into several modules.

| Module   | Description                                                                          | Current Version | Dependency                                                  |
|----------|--------------------------------------------------------------------------------------|-----------------|-------------------------------------------------------------|
| Entities | All database entities, DTOs, DB scripts, required interceptor, interfaces utils etc. | 1.0‑SNAPSHOT    | [Entity Module dependencies](#dependency-for-entity-module) |
| Utils    | Utils for micro-services. Exceptions, Collection, Common, Security Utils etc.        | 1.0-SNAPSHOT    | [Utils Module dependencies](#dependency-for-utils-module)   |

### Dependency for entity module

```xml

<dependency>
    <groupId>com.iAxis.jumghor</groupId>
    <artifactId>entities</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### Dependency for utils module

```xml

<dependency>
    <groupId>com.iAxis.jumghor</groupId>
    <artifactId>entities</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```