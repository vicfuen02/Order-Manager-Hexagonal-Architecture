package com.springbootessentials.springbootessentials.service.order;

import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;


import java.util.List;

public interface OrderService {

    Long createOrder(OrderBDTO order);

    PageBDTO<OrderBDTO> getOrders(Integer pageNumber, Integer pageSize);

    OrderBDTO getOrderById(Long id);
    Long updateOrder(OrderBDTO order);

    OrderBDTO sendOrder(SendOrderBDTO order);
    Long deleteOrder(Long orderId);

    List<OrderBDTO> findSentOrdersByAddressId(Long addressId);

}
