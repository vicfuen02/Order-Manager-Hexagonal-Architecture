package com.springbootessentials.springbootessentials.application.ports.output.order;

import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDao {


    Long createOrder(Order order);

    Pageable<Order> getOrders(Integer pageNumber, Integer pageSize);

    Optional<Order> getOrderById(Long id);
    Long updateOrder(Order order);

    List<Order> findSentOrdersByAddressId(Long id);
    Long deleteOrder(Order orderId);


}
