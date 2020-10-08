FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
EXPOSE 8080
EXPOSE 9010

ADD build/libs/spring-docker-sample-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]
