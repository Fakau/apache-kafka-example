package com.engine.fakau.springbootkafkacosumer.config;

import com.engine.fakau.springbootKafkamodel.model.Product;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic javaguidesTopic(){

        return TopicBuilder.name(topicName)
                .build();
    }

    @Bean
    public NewTopic javaguidesJsonTopic(){
        DefaultKafkaConsumerFactory<String, Product> cf;
        return TopicBuilder.name(topicJsonName)
                //.partitions(10)
                //.replicas(1)
                .build();
    }

}
