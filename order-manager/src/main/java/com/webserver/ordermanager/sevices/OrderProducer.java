package com.webserver.ordermanager.sevices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private KafkaTemplate<String, String> kafkaTemplate;


    private final ObjectMapper objectMapper;

    @Autowired
    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Order order) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(order);
        kafkaTemplate.send("neworder", orderAsMessage);
    }
}
