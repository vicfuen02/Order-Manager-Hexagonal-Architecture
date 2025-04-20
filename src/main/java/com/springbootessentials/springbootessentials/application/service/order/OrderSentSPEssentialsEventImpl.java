package com.springbootessentials.springbootessentials.application.service.order;

import com.springbootessentials.springbootessentials.application.ports.input.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.events.SPEssentialsEvent;
import com.springbootessentials.springbootessentials.application.ports.input.event.SPEssentialsEventListener;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@LogExecutionSPE
@Component
public class OrderSentSPEssentialsEventImpl implements SPEssentialsEventListener {

    @Autowired
    private OrderServiceCommand orderService;


    @Transactional
    @Override
    public void update(SPEssentialsEvent evenEnum, Object data) {

        SendOrder orderSent = (SendOrder) data;

        Order order = this.orderService.getOrderById(orderSent.getOrderId());
        order.setStatus(orderSent.getStatus());

        this.orderService.updateOrder(order);
    }

}
