package com.yadas.web.rest.controller;

import com.yadas.web.rest.service.helper.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Value("${kafka.bootstrap.topic1.name}")
    private String topic1;

    @Value("${kafka.bootstrap.topic2.name}")
    private String topic2;

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
        LOGGER.info("sending payload='{}' to topic='{}'", message, topic1);
        kafkaTemplate.send(topic1, message);
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
        LOGGER.info("sending payload='{}' to topic='{}'", kafkaMessage.toString(), topic2);
        //KafkaMessage kafkaMessageObject = new KafkaMessage(message, hash, producerCode);
        kafkaTemplateObject.send(topic2, kafkaMessage);
        return "Published object messaged successfully : " + kafkaMessage.toString();
    }
}
