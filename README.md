YOUR_USERNAME### Cloud Medical Appointment

In this project, a set of APIs was developed using Spring Boot to control medical appointments. The beginning and end of consultations, exams and treatment will be controlled with their respective values. Good API development practices were applied, including security with Spring Security and access to PostgreSQL databases. It features testing and documentation with Swagger.

#### Docker commands for creating Postgres containerized database
## Run database
docker run --name appointment-db -p 5432:5432 -e POSTGRES_DB=appointment -e POSTGRES_USER=YOUR_USERNAME -e 
POSTGRES_PASSWORD=YOUR_PASSWORD -d postgres:10-alpine

## Stop database
docker stop appointment-db

## Start database
docker start appointment-db