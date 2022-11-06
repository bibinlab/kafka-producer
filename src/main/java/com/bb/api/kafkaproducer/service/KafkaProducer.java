package com.bb.api.kafkaproducer.service;

public interface KafkaProducer {

    void send(String event, int key);
}
