package com.springbootessentials.springbootessentials.service.order.impl.orderSentEvent;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.service.events.SPEssentialsEvent;
import com.springbootessentials.springbootessentials.service.events.SPEssentialsEventListener;
import com.springbootessentials.springbootessentials.service.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@LogExecutionSPE
@Component
public class OrderSentSPEssentialsEventImpl implements SPEssentialsEventListener {

    @Autowired
    private OrderServiceCommand orderService;


    @Override
    public void update(SPEssentialsEvent evenEnum, Object data) {

        SendOrderBDTO orderSent = (SendOrderBDTO) data;

        OrderBDTO order = this.orderService.getOrderById(orderSent.getOrderId());
        order.setStatus(orderSent.getStatus());

        this.orderService.updateOrder(order);
    }

}
