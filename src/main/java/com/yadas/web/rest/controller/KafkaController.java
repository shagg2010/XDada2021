package com.yadas.web.rest.controller;

import com.yadas.web.rest.service.helper.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Value("${kafka.bootstrap.topic1.name}")
    private String topic1;

    @Value("${kafka.bootstrap.topic2.name}")
    private String topicObject;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplateObject;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    /*
        Please refer kafka-readme.txt for commands and docker related details
     */

    @PostMapping("/publish/{message}")
    public String produceMessage(@PathVariable("message") final String message){
        LOGGER.info("sending payload='"+ message +"' to topic='"+ topic1 +"'", message, topic1);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic1, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("[KAFKA] Sent message: " + message + " with offset: " + result.getRecordMetadata().offset() + " to partition: " + result.getRecordMetadata().partition());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message : " + message, ex);
            }
        });
        return "Published messaged successfully : " + message.toString();
    }

    @PostMapping("/publish/msg/")
    public String produceObjectMessage(@RequestParam("message") final String message, @RequestParam("hash") final String hash, @RequestParam("producerCode") final String producerCode){
        LOGGER.info("sending payload='{}' to topic='{}'", message, topic1);
        KafkaMessage kafkaMessageObject = new KafkaMessage(message, hash, producerCode);
        kafkaTemplateObject.send(topic1, kafkaMessageObject);
        return "Published object messaged successfully : " + kafkaMessageObject.toString();
    }

    @PostMapping(path = "/produce/message/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String produceObjectMessageFromJson(@RequestBody KafkaMessage kafkaMessage){
        LOGGER.info("sending payload='"+ kafkaMessage.toString() +"' to topic='"+ topicObject +"'");
        ListenableFuture<SendResult<String, KafkaMessage>> future = kafkaTemplateObject.send(topicObject, kafkaMessage);
        future.addCallback(new ListenableFutureCallback<SendResult<String, KafkaMessage>>() {
            @Override
            public void onSuccess(SendResult<String, KafkaMessage> result) {
                System.out.println("[KAFKA] Sent message: " + result.getProducerRecord().value() + " with offset: " + result.getRecordMetadata().offset() + " to partition: " + result.getRecordMetadata().partition());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message : " + kafkaMessage, ex);
            }
        });
        return "Published object messaged successfully : " + kafkaMessage.toString();
    }
}
