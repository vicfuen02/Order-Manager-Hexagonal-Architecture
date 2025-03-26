package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import com.springbootessentials.springbootessentials.service.events.Event;
import com.springbootessentials.springbootessentials.service.events.EventListener;
import com.springbootessentials.springbootessentials.service.events.SendEventService;
import com.springbootessentials.springbootessentials.service.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.service.order.OrderSendExternalApi;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Async
@Service
public class OrderAsyncServiceImpl implements OrderAsyncService {

//    @Autowired
//    private OrderSendExternalApi orderSendExternalApi;

    @Autowired
    private SendEventService sendEventService;

    @Autowired
    private EventListener orderSentEvent;

    @Autowired
    private CacheManagerService cacheManagerService;


    public void sendOrderAsync(SendOrderBDTO order) {

//        this.orderSendExternalApi.sendOrderToExternalApi(order);

        this.sendEventService.subscribe(Event.ORDER_SENT, orderSentEvent);

        SendOrderBDTO orderSent = new SendOrderBDTO();
        orderSent.setOrderId(order.getOrderId());

        System.out.println("init sleep");
        try {
            this.externalApi();
            orderSent.setStatus(new CodeBDTO.Builder().setCode(OrderSentsEnum.SENT_APPROVED.getCode()).build());
        } catch (RuntimeException e) {
            orderSent.setStatus(new CodeBDTO.Builder().setCode(OrderSentsEnum.SENT_INVALID.getCode()).build());
        }
        System.out.println("end sleep");


        this.sendEventService.notify(Event.ORDER_SENT, orderSent);
        this.cacheManagerService.getCacheAndEvict(new String[] {"/order/sendOrder/{id}"});

        if (order.getOrderId() % 2 == 0) {
            throw new RuntimeException("Exception in sendOrderAsync");
        }

    }


    private void externalApi() throws RuntimeException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
