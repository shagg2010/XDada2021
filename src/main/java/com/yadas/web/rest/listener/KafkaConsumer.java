package com.yadas.web.rest.listener;

import com.yadas.web.rest.service.helper.KafkaMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.bootstrap.topic1.name}", groupId = "${kafka.bootstrap.group1.id}")
    public void consume(String message){
        System.out.println("Consumed Message: " + message);
    }

    @KafkaListener(topics = "${kafka.bootstrap.topic2.name}", groupId = "${kafka.bootstrap.group2.id}", containerFactory = "kafkaListenerContainerFactoryComplexObject")
    public void consume(KafkaMessage kafkaMessage){
        System.out.println("Consumed Complex Message: " + kafkaMessage);
    }
}
