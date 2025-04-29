package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto;

import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.address.dto.AddressResDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.CodeRDTO;

public class OrderResDTO {

    private Long id;
    private String itemName;
    private CodeRDTO status;

    private AddressResDTO address;


    public AddressResDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResDTO address) {
        this.address = address;
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

    public CodeRDTO getStatus() {
        return status;
    }

    public void setStatus(CodeRDTO status) {
        this.status = status;
    }
}
