package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto;

public class SendOrderReqDTO {

    private Long orderId;

    private String sendTo;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }
}
