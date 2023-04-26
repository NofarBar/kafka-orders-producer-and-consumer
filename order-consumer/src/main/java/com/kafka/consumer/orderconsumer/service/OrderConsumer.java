package com.kafka.consumer.orderconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.orderconsumer.dto.ProductDto;
import com.kafka.consumer.orderconsumer.entity.CustomerOrders;
import com.kafka.consumer.orderconsumer.entity.Product;
import com.kafka.consumer.orderconsumer.events.OrderCreatedEvent;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.kafka.consumer.orderconsumer.dto.OrderDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class OrderConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    private final ObjectMapper objectMapper;

    @Autowired
    private CustomerOrderService CustomerOrderService;

    @Autowired
    private ProductsService ProductsService;

    @Autowired
    private PurchasedProductsService PurchasedProductsService;

    @Autowired
    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Autowired
    public OrderConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "neworder")
    public void consume(String message) throws JsonProcessingException, ParseException {

        LOGGER.info(String.format("Message received -> %s", message));
        OrderDto orderDto = objectMapper.readValue(message, OrderDto.class);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderDto.getDate());

        CustomerOrders customerOrders = this.CustomerOrderService.saveCustomerOrder(orderDto);
        for(ProductDto productDto: orderDto.getList_of_products()){
            Product product = this.ProductsService.saveProducts(productDto);
            this.PurchasedProductsService.savePurchasedProducts(productDto, customerOrders.getId(), product.getId());
        }
        OrderCreatedEvent orderCreatedEvent =  new OrderCreatedEvent("orders/created", LocalDate.now(), orderDto.getStore_id(), date);
        ProducerRecord<String, OrderCreatedEvent> newRecord = new ProducerRecord<>("orderCreated", orderCreatedEvent);
        kafkaTemplate.send(newRecord);


    }
}
