package com.springbootessentials.springbootessentials.domain.address;

import com.springbootessentials.springbootessentials.domain.order.Order;

import java.util.List;

public class Address {

    private Long id;

    private String address;

    private List<Order> orders;


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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
