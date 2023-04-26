package com.kafka.consumer.orderconsumer.service;


import com.kafka.consumer.orderconsumer.dto.ProductDto;
import com.kafka.consumer.orderconsumer.entity.Product;
import com.kafka.consumer.orderconsumer.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;


    public Product saveProducts(ProductDto productDto){
        Product product = this.productsRepository.getProductByExternalProductId(productDto.getExternal_product_id());
        if(product == null) {
            product = new Product(productDto.getExternal_product_id(), productDto.getProduct_name(), productDto.getProduct_description(), productDto.getProduct_price());
            return this.productsRepository.save(product);
        }
        return product;
    }
}
