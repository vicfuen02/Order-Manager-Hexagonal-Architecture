package com.springbootessentials.springbootessentials.service.address.dto;

import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;

import java.util.List;

public class AddressBDTO {

    private Long id;

    private String address;

    private List<OrderBDTO> orders;


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

    public List<OrderBDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBDTO> orders) {
        this.orders = orders;
    }
}
