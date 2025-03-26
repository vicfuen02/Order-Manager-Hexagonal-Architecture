package com.springbootessentials.springbootessentials.controller.order.dto;

import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;

public class SendOrderResDTO {

    private Long orderId;
    private CodeBDTO status;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public CodeBDTO getStatus() {
        return status;
    }

    public void setStatus(CodeBDTO status) {
        this.status = status;
    }
}
