package com.springbootessentials.springbootessentials.domain.order;

import com.springbootessentials.springbootessentials.domain.address.Address;
import com.springbootessentials.springbootessentials.domain.common.Code;

public class Order {

    private Long id;
    private String itemName;
    private Code status;

    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public Code getStatus() {
        return status;
    }

    public void setStatus(Code status) {
        this.status = status;
    }
}
