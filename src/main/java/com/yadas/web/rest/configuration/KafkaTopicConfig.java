package com.yadas.web.rest.configuration;

import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.bootstrap.address}")
    private String kafkaBootstrapAddress;

    @Value("${kafka.bootstrap.topic1.name}")
    private String topic1;

    @Value("${kafka.bootstrap.topic2.name}")
    private String topicObject;

    private int numberOfPartitions = 1;
    private short replicationFactor = (short) 1;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return topicExists(topic1)?null:new NewTopic(topic1, numberOfPartitions, replicationFactor);
    }

    @Bean
    public NewTopic topicObject() {
        return topicExists(topicObject)?null:new NewTopic(topicObject, numberOfPartitions, replicationFactor);
    }

    public boolean topicExists(String topicName){
        boolean result = false;
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapAddress);
        try (AdminClient client = AdminClient.create(configs)) {
            ListTopicsOptions options = new ListTopicsOptions();
            options.listInternal(false); // includes internal topics such as __consumer_offsets
            ListTopicsResult topics = client.listTopics(options);
            Set<String> currentTopicList = topics.names().get();
            System.out.println(">>> currentTopicList: " + currentTopicList);
            result = currentTopicList.contains(topicName);
            System.out.println(">>> currentTopicList result: " + result + " for [" + topicName + "]");
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}