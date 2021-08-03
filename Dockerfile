FROM openjdk:16-slim
LABEL maintainer="Fred Oliveira"
COPY application/build/libs/application.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/application.jar"]
