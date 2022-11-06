package com.bb.api.kafkaproducer.service.impl;

import com.bb.api.kafkaproducer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<Integer, String> template;
    private final String topicName;

    public KafkaProducerImpl(KafkaTemplate<Integer, String> template,@Value("${kafka.topic-name}") String topicName) {
        this.template = template;
        this.topicName = topicName;
    }

    @Override
    public void send(String event, int key) {
        log.info("send invoked with key:{} | event:{}",key, event);
        template.send(topicName, key, event);
    }
}
