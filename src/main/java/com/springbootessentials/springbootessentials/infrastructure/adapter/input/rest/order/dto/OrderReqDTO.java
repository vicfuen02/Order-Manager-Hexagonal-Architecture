package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto;

import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.address.dto.AddressReqDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.CodeRDTO;

public class OrderReqDTO {

    private Long id;
    private String itemName;
    private CodeRDTO status;
    private AddressReqDTO address;

    public AddressReqDTO getAddress() {
        return address;
    }

    public void setAddress(AddressReqDTO address) {
        this.address = address;
    }

    public CodeRDTO getStatus() {
        return status;
    }

    public void setStatus(CodeRDTO status) {
        this.status = status;
    }

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
}
