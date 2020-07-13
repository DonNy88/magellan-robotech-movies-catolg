FROM openjdk:8-jdk as BUILD
WORKDIR /app
COPY . .
RUN ./mvnw clean package -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=BUILD /app/target/MoviesCatalog-*.jar MoviesCatalog.jar
EXPOSE 8080
CMD ["java", "-jar", "MoviesCatalog.jar"]