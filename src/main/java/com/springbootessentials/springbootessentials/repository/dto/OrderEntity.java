package com.springbootessentials.springbootessentials.repository.dto;

import com.springbootessentials.springbootessentials.repository.common.dto.Code;

public class OrderEntity {

    private Long id;
    private String itemName;

    private Code status;


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

    public Code getStatus() {
        return status;
    }

    public void setStatus(Code status) {
        this.status = status;
    }
}
