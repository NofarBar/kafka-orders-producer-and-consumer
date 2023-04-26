package com.kafka.consumer.orderconsumer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

public class OrderDto {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String date;
    private String shopper_email;
    private String shopper_first_name;
    private String shopper_last_name;
    private List<ProductDto> list_of_productDtos;

    private int store_id;

    public OrderDto(String date, String shopper_email, String shopper_first_name, String shopper_last_name, List<ProductDto> list_of_productDtos, int store_id) {
        this.date = date;
        this.shopper_email = shopper_email;
        this.shopper_first_name = shopper_first_name;
        this.shopper_last_name = shopper_last_name;
        this.list_of_productDtos = list_of_productDtos;
        this.store_id = store_id;
    }

    public List<ProductDto> getList_of_productDtos() {
        return list_of_productDtos;
    }

    public void setList_of_productDtos(List<ProductDto> list_of_productDtos) {
        this.list_of_productDtos = list_of_productDtos;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public String getDate() {
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

    public List<ProductDto> getList_of_products() {
        return list_of_productDtos;
    }

    public void setDate(String date) {
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

    public void setList_of_products(List<ProductDto> list_of_productDtos) {
        this.list_of_productDtos = list_of_productDtos;
    }
}
