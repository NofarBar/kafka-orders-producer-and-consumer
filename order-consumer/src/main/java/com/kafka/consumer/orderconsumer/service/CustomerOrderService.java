package com.kafka.consumer.orderconsumer.service;


import com.kafka.consumer.orderconsumer.dto.OrderDto;
import com.kafka.consumer.orderconsumer.entity.CustomerOrders;
import com.kafka.consumer.orderconsumer.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;


    public CustomerOrders saveCustomerOrder(OrderDto orderDto) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderDto.getDate());

        CustomerOrders customerorders =  new CustomerOrders(date, orderDto.getShopper_email(), orderDto.getShopper_first_name(), orderDto.getShopper_last_name());
        return this.customerOrderRepository.save(customerorders);

    }
}
