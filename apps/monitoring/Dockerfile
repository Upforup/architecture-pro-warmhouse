FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY monitoring/pom.xml .
COPY monitoring/src ./src
COPY smart_home/openapi.yaml ./smart_home/openapi.yaml
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/monitoring-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
