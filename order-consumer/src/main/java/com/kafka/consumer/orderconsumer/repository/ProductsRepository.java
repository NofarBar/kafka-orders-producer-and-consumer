package com.kafka.consumer.orderconsumer.repository;

import com.kafka.consumer.orderconsumer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.external_product_id = ?1")
    Product getProductByExternalProductId(int external_product_id);
}
