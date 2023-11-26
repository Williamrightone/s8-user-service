FROM openjdk:17-alpine
COPY ./target/*.jar user-service.jar
RUN sh -c 'touch user-service.jar'
EXPOSE 8091
ENTRYPOINT ["java","-jar","user-service.jar"]