package com.springbootessentials.springbootessentials.repository;

import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryMock {

    Long createOrder(OrderEntity order);

    List<OrderEntity> getOrders();

    Optional<OrderEntity> getOrderById(Long id);
    Long updateOrder(OrderEntity order);


}
