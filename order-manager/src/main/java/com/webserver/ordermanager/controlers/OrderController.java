package com.webserver.ordermanager.controlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webserver.ordermanager.sevices.OrderProducer;
import com.webserver.ordermanager.sevices.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    public OrderController() {
    }

    @PostMapping("/{store_id}/orders")
    public ResponseEntity<String> publish(@PathVariable(value="store_id") String store_id, @RequestBody Order order) throws JsonProcessingException {
        order.setStore_id(Integer.parseInt(store_id));
        this.orderProducer.sendMessage(order);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
