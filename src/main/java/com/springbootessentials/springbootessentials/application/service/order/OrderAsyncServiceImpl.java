package com.springbootessentials.springbootessentials.application.service.order;

import com.springbootessentials.springbootessentials.application.ports.input.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.application.service.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.application.ports.input.cache.CacheManagerService;
import com.springbootessentials.springbootessentials.domain.common.Code;
import com.springbootessentials.springbootessentials.domain.events.SPEssentialsEvent;
import com.springbootessentials.springbootessentials.application.ports.input.event.SPEssentialsEventListener;
import com.springbootessentials.springbootessentials.application.ports.input.event.SendSPEssentialsEventService;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;
import com.springbootessentials.springbootessentials.domain.order.OrderSentsEnum;
import com.springbootessentials.springbootessentials.domain.exception.OrderExceptionsEnum;
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


    public void sendOrderAsync(SendOrder order) {

        this.sendSPEssentialsEventService.subscribe(SPEssentialsEvent.ORDER_SENT, orderSentEvent);

        SendOrder orderSent = new SendOrder();
        orderSent.setOrderId(order.getOrderId());

        log.info("Calling external api");
        try {
            this.externalApi();
            orderSent.setStatus(new Code(OrderSentsEnum.SENT_APPROVED.getCode(), null));
        } catch (RuntimeException e) {
            orderSent.setStatus(new Code(OrderSentsEnum.SENT_INVALID.getCode(), null));
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
