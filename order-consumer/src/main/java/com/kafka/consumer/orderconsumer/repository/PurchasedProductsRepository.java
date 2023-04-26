package com.kafka.consumer.orderconsumer.repository;

import com.kafka.consumer.orderconsumer.entity.PurchasedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedProductsRepository extends JpaRepository<PurchasedProducts, Long> {
}
