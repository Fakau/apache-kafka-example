package com.engine.fakau.springbootkafkacosumer.service;

import com.engine.fakau.springbootkafkacosumer.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC_NAME      = "javaguides";
    private static final String TOPIC_NAME_JSON = "javaguides_json";
    private static final String GROUPE_ID       = "myGroupe";

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUPE_ID)
    public void consumer(String message){
        System.out.println(message);
    }

    @KafkaListener(topics = TOPIC_NAME_JSON, groupId = GROUPE_ID)
    public void consumerJson(Product product){
        System.out.println(product);
    }
}
