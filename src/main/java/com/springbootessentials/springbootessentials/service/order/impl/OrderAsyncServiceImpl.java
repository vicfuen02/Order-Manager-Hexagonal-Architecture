package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.common.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import com.springbootessentials.springbootessentials.service.events.SPEssentialsEvent;
import com.springbootessentials.springbootessentials.service.events.SPEssentialsEventListener;
import com.springbootessentials.springbootessentials.service.events.SendSPEssentialsEventService;
import com.springbootessentials.springbootessentials.service.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
import com.springbootessentials.springbootessentials.service.order.exceptions.OrderExceptionsEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@LogExecutionSPE
@Async
@Service
public class OrderAsyncServiceImpl implements OrderAsyncService {

    private static final Logger log = LogManager.getLogger(OrderAsyncServiceImpl.class);

    @Autowired
    private SendSPEssentialsEventService sendSPEssentialsEventService;

    @Autowired
    private SPEssentialsEventListener orderSentEvent;

    @Autowired
    private CacheManagerService cacheManagerService;


    public void sendOrderAsync(SendOrderBDTO order) {

        this.sendSPEssentialsEventService.subscribe(SPEssentialsEvent.ORDER_SENT, orderSentEvent);

        SendOrderBDTO orderSent = new SendOrderBDTO();
        orderSent.setOrderId(order.getOrderId());

        log.info("Calling external api");
        try {
            this.externalApi();
            orderSent.setStatus(new CodeBDTO(OrderSentsEnum.SENT_APPROVED.getCode(), null));
        } catch (RuntimeException e) {
            orderSent.setStatus(new CodeBDTO(OrderSentsEnum.SENT_INVALID.getCode(), null));
        }
        log.info("Ending call external api");

        this.sendSPEssentialsEventService.notify(SPEssentialsEvent.ORDER_SENT, orderSent);
        this.cacheManagerService.getCacheAndEvict("/order/sendOrder/{id}");

        if (order.getOrderId() % 2 == 0) {
            throw SPEssentialsExceptionFactory.throwException(OrderExceptionsEnum.ORDER_NOT_SENT);
        }

    }


    private void externalApi() throws RuntimeException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
