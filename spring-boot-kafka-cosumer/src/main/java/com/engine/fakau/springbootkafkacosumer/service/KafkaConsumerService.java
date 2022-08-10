package com.engine.fakau.springbootkafkacosumer.service;

import com.engine.fakau.springbootKafkamodel.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener( topics = "${spring.kafka.topic.name}",
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String message){
        System.out.println(message);
    }

    @KafkaListener( topics = "${spring.kafka.topic-json.name}",
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consumerJson(Product product){
        System.out.println(product);
    }
}
