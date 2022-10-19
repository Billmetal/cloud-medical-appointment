### Cloud Medical Appointment

## Run database
docker run --name appointment-db -p 5432:5432 -e POSTGRES_DB=appointment -e POSTGRES_USER=admin -e 
POSTGRES_PASSWORD=adm123 -d postgres:10-alpine

## Stop database
docker stop appointment-db

## Start database
docker start appointment-db