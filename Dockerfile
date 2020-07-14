FROM openjdk:8-jdk as BUILD
WORKDIR /app
COPY . .
RUN ./mvnw clean package -Dmaven.test.skip=false

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=BUILD /app/target/MoviesCatalog-*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
