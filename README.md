# fasa-app
# Spring Boot Application with Docker Compose

Fasa App Validation

---

## Prerequisites

Before you begin, ensure you have the following installed:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## Project Structure
project:
name: spring-boot-docker-app
structure:
- Dockerfile: "Containerizes your Spring Boot app"
- docker-compose.yml: "Manages service setup via Docker Compose"
- README.md: "Project documentation"
- HELP.md: "Extra instructions or guides"
- build:
description: "Gradle build output, includes JAR"
- build.gradle.kts: "Gradle Kotlin DSL build configuration"
- gradle:
description: "Gradle wrapper scripts and configuration"
- gradlew: "Unix Gradle wrapper"
- gradlew.bat: "Windows Gradle wrapper"
- settings.gradle.kts: "Gradle project settings"
- src:
description: "Application source code"

## Running Application : 

1. **Running the application :**
```bash
	./gradlew clean build
```

```bash
docker-compose up --build
```
2. **Accessing the application:**

Access the application at: http://localhost:8080

3. **Stopping the application (if already running):**
```bash
docker-compose down
```
 


