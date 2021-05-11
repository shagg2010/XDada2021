FROM openjdk:11
COPY build/libs/rest-0.0.1-SNAPSHOT.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=dev"]
