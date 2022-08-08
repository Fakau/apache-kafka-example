package com.engine.fakau.springbootkafkaproducer.web;

import com.engine.fakau.springbootkafkaproducer.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageResource {

    private final KafkaProducerService kafkaProducerService;

    public MessageResource(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") final String message){
        this.kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }
}
