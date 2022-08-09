package com.engine.fakau.springbootkafkaproducer.web;

import com.engine.fakau.springbootkafkaproducer.model.Product;
import com.engine.fakau.springbootkafkaproducer.service.KafkaProducerJsonService;
import com.engine.fakau.springbootkafkaproducer.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageResource {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaProducerJsonService kafkaProducerJsonService;

    public MessageResource(KafkaProducerService kafkaProducerService, KafkaProducerJsonService kafkaProducerJsonService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaProducerJsonService = kafkaProducerJsonService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") final String message){
        this.kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publish(@RequestBody final Product message){
        this.kafkaProducerJsonService.sendMessage(message);
        return ResponseEntity.ok("Json message send to the topic");
    }
}
