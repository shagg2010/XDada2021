package com.yadas.web.rest.service.helper;

public class KafkaMessage {

    private String message;
    private String hash;
    private String producerCode;

    public KafkaMessage() {
        //this is required during deserialization when msg is read from Kafka topic
    }

    public KafkaMessage(String message, String hash, String producerCode) {
        this();
        this.message = message;
        this.hash = hash;
        this.producerCode = producerCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    @Override
    public String toString() {
        return "KafkaMessage {" +
                "message='" + message + '\'' +
                ", hash='" + hash + '\'' +
                ", producerCode='" + producerCode + '\'' +
                '}';
    }
}
