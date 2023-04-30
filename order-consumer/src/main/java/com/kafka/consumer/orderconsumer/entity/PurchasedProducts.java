package com.kafka.consumer.orderconsumer.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PurchasedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long order_id;
    private Long product_id;
    private int quantity;

    public PurchasedProducts(){

    }
    public PurchasedProducts(Long order_id, Long product_id, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
