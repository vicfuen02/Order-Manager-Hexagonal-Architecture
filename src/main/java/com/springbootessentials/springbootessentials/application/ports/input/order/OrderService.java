package com.springbootessentials.springbootessentials.application.ports.input.order;

import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;


import java.util.List;

public interface OrderService {

    Long createOrder(Order order);

    Pageable<Order> getOrders(Integer pageNumber, Integer pageSize);

    Order getOrderById(Long id);
    Long updateOrder(Order order);

    Order sendOrder(SendOrder order);
    Long deleteOrder(Long orderId);

    List<Order> findSentOrdersByAddressId(Long addressId);

}
