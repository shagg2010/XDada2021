===================================================================================
================= To Run Kafka On Locally On Windows and Validate =================
===================================================================================
Install and Create Kafka Topic locally on Windows and check if it is working correctly-

    .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic1
    .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topicObject
    .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic topic1
            >msg
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic topicObject
            > {"message": "message from m1", "hash" : "hash from h1", "producerCode": "producer from p1" }
            > {"message": "message from m2", "hash" : "hash from h2", "producerCode": "producer from p2" }
    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1 --from-beginning
    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topicObject --from-beginning

=======================================================================
================= To Run Kafka On Docker and Validate =================
=======================================================================

Kafka Running On Docker Image (Using exec /bin/bash)
----------------------------------------------------
These clients, from other containers on the same Docker network, will use the kafka container service hostname to connect to Kafka.
./opt/bitnami/kafka/bin/kafka-console-producer.sh --broker-list kafka:9093 --topic topic1
./opt/bitnami/kafka/bin/kafka-console-producer.sh --broker-list kafka:9093 --topic topicObject

./opt/bitnami/kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic topic1 --from-beginning
./opt/bitnami/kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic topicObject --from-beginning

Kafka Running On Docker Image (Using local Windows host)
--------------------------------------------------------
These clients, from the host, will use localhost to connect to Kafka.
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9093 --topic topic1
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9093 --topic topicObject

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9093 --topic topic1 --from-beginning
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9093 --topic topicObject --from-beginning

