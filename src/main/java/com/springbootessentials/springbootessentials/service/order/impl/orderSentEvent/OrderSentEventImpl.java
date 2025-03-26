package com.springbootessentials.springbootessentials.service.order.impl.orderSentEvent;

import com.springbootessentials.springbootessentials.service.events.Event;
import com.springbootessentials.springbootessentials.service.events.EventListener;
import com.springbootessentials.springbootessentials.service.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSentEventImpl implements EventListener {

    @Autowired
    private OrderServiceCommand orderService;


    @Override
    public void update(Event evenEnum, Object data) {

        SendOrderBDTO orderSent = (SendOrderBDTO) data;

        OrderBDTO order = this.orderService.getOrderById(orderSent.getOrderId());
        order.setStatus(orderSent.getStatus());

        this.orderService.updateOrder(order);
    }

}
