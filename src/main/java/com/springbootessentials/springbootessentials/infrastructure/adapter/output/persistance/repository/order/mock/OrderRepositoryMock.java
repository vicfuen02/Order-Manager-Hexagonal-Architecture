package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.mock;

import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryMock {

    Long createOrder(OrderEntity order);

    Pageable<OrderEntity> getOrders(Integer pageNumber, Integer pageSize);

    Optional<OrderEntity> getOrderById(Long id);
    Long updateOrder(OrderEntity order);

    List<OrderEntity> findSentOrdersByAddressId(Long id);

    Long deleteOrder(Long id);


}
