package com.springbootessentials.springbootessentials.repository;

import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryMock {

    Long createOrder(OrderEntity order);

    PageBDTO<OrderEntity> getOrders(Integer pageNumber, Integer pageSize);

    Optional<OrderEntity> getOrderById(Long id);
    Long updateOrder(OrderEntity order);

    List<OrderEntity> findSentOrdersByAddressId(Long id);

    Long deleteOrder(Long id);


}
