FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ARG JAR_FILE=target/demoCRUD-0.0.1-SNAPSHOT.jar
ARG JSON_FILE=data.json
ADD ${JAR_FILE} app.jar
ADD ${JSON_FILE} data.json
ENTRYPOINT ["java","-jar","/app.jar"]