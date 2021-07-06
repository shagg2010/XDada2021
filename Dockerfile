FROM openjdk:11
COPY build/libs/rest-0.0.1-SNAPSHOT.jar /usr/src/app/app.jar
COPY resources/wait-for.sh /usr/src/app/
COPY resources/wait-for-it.sh /usr/src/app/
COPY resources/start-application.sh /usr/src/app/
WORKDIR /usr/src/app
RUN mkdir -p cassandra_cql
COPY resources/preload-cassandra-1.3.jar /usr/src/app/
COPY resources/cassandra/*.cql /usr/src/app/cassandra_cql/
RUN mkdir -p resources
RUN apt-get -q update && apt-get -qy install netcat
