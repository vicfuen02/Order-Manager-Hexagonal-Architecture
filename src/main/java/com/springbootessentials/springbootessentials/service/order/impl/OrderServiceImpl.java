package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    public Long createOrder(OrderBDTO order) {
        return null;
    }

    public List<OrderBDTO> getOrders() {
        return new ArrayList<>();
    }


}
