package com.springbootessentials.springbootessentials.service.order.dto;

import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;

public class OrderBDTO {

    private Long id;
    private String itemName;
    private CodeBDTO status;

    private AddressBDTO address;


    public AddressBDTO getAddress() {
        return address;
    }

    public void setAddress(AddressBDTO address) {
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

    public CodeBDTO getStatus() {
        return status;
    }

    public void setStatus(CodeBDTO status) {
        this.status = status;
    }
}
