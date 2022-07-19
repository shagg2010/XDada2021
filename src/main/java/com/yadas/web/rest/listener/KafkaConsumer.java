package com.yadas.web.rest.listener;

import com.yadas.web.rest.controller.KafkaController;
import com.yadas.web.rest.service.helper.KafkaMessage;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(id = "complex", topics = "${kafka.bootstrap.topic2.name}", groupId = "${kafka.bootstrap.group2.id}", containerFactory = "kafkaListenerContainerFactoryComplexObject")
    public void consumer(KafkaMessage kafkaMessage, Consumer<?, ?> consumer){
        System.out.println("[KAFKA] Consumed Complex Message: " + kafkaMessage);
    }

    @KafkaListener(topics = "${kafka.bootstrap.topic1.name}", groupId = "${kafka.bootstrap.group1.id}")
    public void consumer(String message){
        System.out.println("[KAFKA] Consumed Message: " + message);
    }

}
