package com.kafka.consumer.orderconsumer.service;


import com.kafka.consumer.orderconsumer.dto.ProductDto;
import com.kafka.consumer.orderconsumer.entity.PurchasedProducts;
import com.kafka.consumer.orderconsumer.repository.PurchasedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedProductsService {

    @Autowired
    private PurchasedProductsRepository purchasedProductsRepository;


    public void savePurchasedProducts(ProductDto productDto, Long order_id, Long product_id){
        PurchasedProducts purchasedProducts = new PurchasedProducts(order_id, product_id,productDto.getQuantity());
        purchasedProductsRepository.save(purchasedProducts);
    }
}
