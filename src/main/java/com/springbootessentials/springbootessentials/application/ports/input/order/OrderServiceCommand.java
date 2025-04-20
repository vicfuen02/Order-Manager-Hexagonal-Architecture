package com.springbootessentials.springbootessentials.application.ports.input.order;

import com.springbootessentials.springbootessentials.domain.order.Order;

public interface OrderServiceCommand {


    Order getOrderById(Long id);
    Long updateOrder(Order order);

}
