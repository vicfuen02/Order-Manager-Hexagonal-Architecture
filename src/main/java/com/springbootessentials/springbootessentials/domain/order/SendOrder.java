package com.springbootessentials.springbootessentials.domain.order;

import com.springbootessentials.springbootessentials.domain.common.Code;

public class SendOrder {

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
