//package com.springbootessentials.springbootessentials.service.order.impl;
//
//import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
//import com.springbootessentials.springbootessentials.service.events.Event;
//import com.springbootessentials.springbootessentials.service.events.EventListener;
//import com.springbootessentials.springbootessentials.service.events.SendEventService;
//import com.springbootessentials.springbootessentials.service.order.OrderSendExternalApi;
//import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
//import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class OrderSendExternalApiImpl implements OrderSendExternalApi {
//
//
//    @Autowired
//    private SendEventService sendEventService;
//
//    @Autowired
//    private OrderSendExternalApi orderSendExternalApi;
//
//    @Autowired
//    private EventListener orderSentEvent;
//
//    @Override
//    public void sendOrderToExternalApi(SendOrderBDTO order)  {
//
//        this.sendEventService.subscribe(Event.ORDER_SENT, orderSentEvent);
//
//        SendOrderBDTO orderSent = new SendOrderBDTO();
//        orderSent.setOrderId(order.getOrderId());
//        System.out.println("init sleep");
//        try {
//            this.externalApi();
//        } catch (RuntimeException e) {
//            orderSent.setStatus(new CodeBDTO.Builder().setCode(OrderSentsEnum.SENT_INVALID.getCode()).build());
//        }
//
//        System.out.println("end sleep");
//        orderSent.setStatus(new CodeBDTO.Builder().setCode(OrderSentsEnum.SENT_APPROVED.getCode()).build());
//
//        this.sendEventService.notify(Event.ORDER_SENT, orderSent);
//    }
//
//    private void externalApi() throws RuntimeException {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
