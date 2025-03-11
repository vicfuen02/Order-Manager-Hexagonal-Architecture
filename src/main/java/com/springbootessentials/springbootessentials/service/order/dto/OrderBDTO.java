package com.springbootessentials.springbootessentials.service.order.dto;

public class OrderBDTO {

    private Long id;
    private String itemName;


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
