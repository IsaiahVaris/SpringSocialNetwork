FROM openjdk:11
VOLUME /tmp
EXPOSE 9090
ADD target/springsocialnetwork-0.0.1-SNAPSHOT.jar springsocialnetwork-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "springsocialnetwork-0.0.1-SNAPSHOT.jar"]

