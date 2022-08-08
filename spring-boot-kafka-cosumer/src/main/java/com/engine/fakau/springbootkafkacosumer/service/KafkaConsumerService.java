package com.engine.fakau.springbootkafkacosumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "javaguides", groupId = "myGroupe")
    public void consumer(String message){
        System.out.println(message);
    }
}
