package com.kafka.consumer.orderconsumer.events;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class OrderCreatedEvent {

   private String event_name;
   private LocalDate Order_entity_creation_date;
   private int store_id;
   private Date actual_order_data;

    public OrderCreatedEvent(){}

    public OrderCreatedEvent(String event_name, LocalDate order_entity_creation_date, int store_id, Date actual_order_data) {
        this.event_name = event_name;
        this.Order_entity_creation_date = order_entity_creation_date;
        this.store_id = store_id;
        this.actual_order_data = actual_order_data;
    }

    public String getEvent_name() {
        return event_name;
    }

    public LocalDate getOrder_entity_creation_date() {
        return Order_entity_creation_date;
    }

    public int getStore_id() {
        return store_id;
    }

    public Date getActual_order_data() {
        return actual_order_data;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setOrder_entity_creation_date(LocalDate order_entity_creation_date) {
        Order_entity_creation_date = order_entity_creation_date;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public void setActual_order_data(Date actual_order_data) {
        this.actual_order_data = actual_order_data;
    }
}
