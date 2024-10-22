package com.example.moviesdvdmicroservices.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic customerRegistrationTopic() {
        return TopicBuilder
                .name("customer-placed")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic rentalTopic() {
        return TopicBuilder
                .name("rental-placed")
                .partitions(3)
                .replicas(1)
                .build();
    }
}