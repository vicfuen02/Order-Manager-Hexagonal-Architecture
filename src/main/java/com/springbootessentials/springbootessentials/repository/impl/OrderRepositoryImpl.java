package com.springbootessentials.springbootessentials.repository.impl;

import com.springbootessentials.springbootessentials.SpringbootessentialsApplication;
import com.springbootessentials.springbootessentials.repository.OrderRepository;
import com.springbootessentials.springbootessentials.repository.dto.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {


    @Override
    public Long createOrder(OrderEntity order) {

        Long nextId = this.getOrders().stream()
                .reduce((first, second) -> second)
                .map(OrderEntity::getId)
                .orElse(1000L) + 1L;

        order.setId(nextId);
        SpringbootessentialsApplication.getOrders().add(order);
        return order.getId();
    }

    @Override
    public List<OrderEntity> getOrders() {
        return SpringbootessentialsApplication.getOrders();
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return SpringbootessentialsApplication.getOrders()
                .stream()
                .filter(orderEntity -> orderEntity.getId().equals(id))
                .findFirst();
    }
    @Override
    public Long updateOrder(OrderEntity order) {

        OrderEntity orderResult = SpringbootessentialsApplication.getOrders()
                .stream()
                .filter(or -> or.getId().equals(order.getId()))
                .findFirst().orElse(new OrderEntity());

        orderResult.setItemName(order.getItemName());

        return order.getId();
    }
}
