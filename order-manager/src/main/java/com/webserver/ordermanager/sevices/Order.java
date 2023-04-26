package com.webserver.ordermanager.sevices;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private String shopper_email;
    private String shopper_first_name;
    private String shopper_last_name;
    private List<Product> list_of_products;

    private int store_id;

    public Order(LocalDateTime date, String shopper_email, String shopper_first_name, String shopper_last_name, List<Product> list_of_products) {
        this.date = date;
        this.shopper_email = shopper_email;
        this.shopper_first_name = shopper_first_name;
        this.shopper_last_name = shopper_last_name;
        this.list_of_products = list_of_products;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public LocalDateTime getDate() {
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

    public List<Product> getList_of_products() {
        return list_of_products;
    }

    public void setDate(LocalDateTime date) {
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

    public void setList_of_products(List<Product> list_of_products) {
        this.list_of_products = list_of_products;
    }
}
