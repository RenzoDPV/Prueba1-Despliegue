# Etapa 1: construir el .jar
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: ejecutar el .jar
FROM amazoncorretto:23.0.2-al2023
WORKDIR /app
COPY --from=build /app/target/free_mind-0.0.1-SNAPSHOT.jar /app/api-freemind-v1.jar
ENTRYPOINT ["java", "-jar", "/app/api-freemind-v1.jar"]
