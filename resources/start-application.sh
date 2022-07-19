#!/bin/sh
printf "======================================= Preloading Cassandra Database from CQLs ===============================\n "
java -jar preload-cassandra-1.3.jar cassandra 9042 /usr/src/app/cassandra_cql/
printf "========================================= ----------------------------------- =================================\n "
printf "========================================= Starting Java Application On Docker =================================\n "
printf "========================================= ----------------------------------- =================================\n "
java -jar app.jar --spring.profiles.active=dev
