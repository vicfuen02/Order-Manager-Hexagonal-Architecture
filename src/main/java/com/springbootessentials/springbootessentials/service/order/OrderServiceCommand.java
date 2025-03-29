package com.springbootessentials.springbootessentials.service.order;

import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;

public interface OrderServiceCommand {


    OrderBDTO getOrderById(Long id);
    Long updateOrder(OrderBDTO order);

}
