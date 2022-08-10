package com.engine.fakau.springbootkafkaproducer.service;

import com.engine.fakau.springbootKafkamodel.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJsonService {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public KafkaProducerJsonService(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Product product){
        Message<Product> message = MessageBuilder
                .withPayload(product)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        kafkaTemplate.send(message);
    }
}
