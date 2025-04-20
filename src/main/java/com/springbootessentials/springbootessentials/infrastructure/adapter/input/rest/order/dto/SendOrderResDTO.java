package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto;

import com.springbootessentials.springbootessentials.domain.common.Code;

public class SendOrderResDTO {

    private Long orderId;
    private Code status;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Code getStatus() {
        return status;
    }

    public void setStatus(Code status) {
        this.status = status;
    }
}
