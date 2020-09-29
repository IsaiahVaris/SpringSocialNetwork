FROM openjdk:11
VOLUME /tmp
EXPOSE 9090
#ADD springsocialnetwork-0.0.1-SNAPSHOT.jar springsocialnetwork-0.0.1-SNAPSHOT.jar
ENTRYPOINT .mvnw spring-boot:run

