package com.springbootessentials.springbootessentials.service.order;

import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;

import java.util.List;

public interface OrderService {

    Long createOrder(OrderBDTO order);

    List<OrderBDTO> getOrders();

    OrderBDTO getOrderById(Long id);
    Long updateOrder(OrderBDTO order);

    OrderBDTO sendOrder(SendOrderBDTO order);

}
