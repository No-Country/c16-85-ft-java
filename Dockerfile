# Dockerfile

# Etapa de construcción del frontend
FROM node:16.13.0 AS frontend-builder
WORKDIR /app
COPY ./marketplace/package.json ./marketplace/package-lock.json ./
RUN npm install
COPY ./marketplace .
RUN npm run build

# Etapa de construcción del backend
FROM openjdk:17-jdk AS backend-builder
WORKDIR /app
COPY ./target/com.market-place-c16-85-0.0.1-SNAPSHOT.jar ./springdemo.jar

# Imagen final
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=backend-builder /app/springdemo.jar ./
COPY --from=frontend-builder /app/build ./frontend
EXPOSE 8080
CMD ["java", "-jar", "springdemo.jar"]
