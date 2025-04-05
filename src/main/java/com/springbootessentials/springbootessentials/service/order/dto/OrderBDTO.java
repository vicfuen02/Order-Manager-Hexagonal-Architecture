package com.springbootessentials.springbootessentials.service.order.dto;

import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;

public class OrderBDTO {

    private Long id;
    private String itemName;
    private CodeBDTO status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public CodeBDTO getStatus() {
        return status;
    }

    public void setStatus(CodeBDTO status) {
        this.status = status;
    }
}
