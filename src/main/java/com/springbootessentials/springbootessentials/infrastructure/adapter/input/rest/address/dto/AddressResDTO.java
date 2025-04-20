package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.address.dto;

import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.OrderResDTO;

import java.util.List;

public class AddressResDTO {

    private Long id;

    private String address;

    private List<OrderResDTO> orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderResDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderResDTO> orders) {
        this.orders = orders;
    }
}
