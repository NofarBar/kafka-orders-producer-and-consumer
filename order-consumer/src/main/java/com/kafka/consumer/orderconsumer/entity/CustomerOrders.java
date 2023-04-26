package com.kafka.consumer.orderconsumer.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CustomerOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String shopper_email;
    private String shopper_first_name;
    private String shopper_last_name;

    public CustomerOrders(){

    }
    public CustomerOrders(Date date, String shopper_email, String shopper_first_name, String shopper_last_name) {
        super();
        this.date = date;
        this.shopper_email = shopper_email;
        this.shopper_first_name = shopper_first_name;
        this.shopper_last_name = shopper_last_name;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getShopper_email() {
        return shopper_email;
    }

    public String getShopper_first_name() {
        return shopper_first_name;
    }

    public String getShopper_last_name() {
        return shopper_last_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setShopper_email(String shopper_email) {
        this.shopper_email = shopper_email;
    }

    public void setShopper_first_name(String shopper_first_name) {
        this.shopper_first_name = shopper_first_name;
    }

    public void setShopper_last_name(String shopper_last_name) {
        this.shopper_last_name = shopper_last_name;
    }
}
