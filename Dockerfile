FROM eclipse-temurin:21.0.5_11-jdk
EXPOSE  8080
WORKDIR /app
COPY  .mvn ./.mvn
COPY  mvnw .
COPY  pom.xml .

RUN ./mvnw dependency:go-offline 

COPY src ./src

RUN ./mvnw clean install -DskipTest

ENTRYPOINT [ "java","-ajr","/app/target/apirest-0.0.1-SNAPSHOT.jar" ]