package com.kafka.consumer.orderconsumer.repository;

import com.kafka.consumer.orderconsumer.entity.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrders, Long> {
}