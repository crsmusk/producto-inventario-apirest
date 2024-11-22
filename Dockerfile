FROM eclipse-temurin:21.0.5_11-jdk
EXPOSE  8080
WORKDIR /app
COPY  ./.mvn /app/.mvn
COPY  ./mvnw /app
COPY ./pom.xml /app

RUN ./mvnw dependency:go-offline 

COPY ./src /app

RUN ./mvnw clean install -DskipTest

ENTRYPOINT [ "java","-ajr","/app/target/apirest-0.0.1-SNAPSHOT.jar" ]