package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.mock;

import com.springbootessentials.springbootessentials.SpringbootessentialsApplication;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@LogExecutionSPE
public class OrderRepositoryMockImpl implements OrderRepositoryMock {


    @Override
    public Long createOrder(OrderEntity order) {

        Long nextId = SpringbootessentialsApplication.getOrders().stream()
                .reduce((first, second) -> second)
                .map(OrderEntity::getId)
                .orElse(1000L) + 1L;

        order.setId(nextId);
        SpringbootessentialsApplication.getOrders().add(order);
        return order.getId();
    }


    @Override
    public Pageable<OrderEntity> getOrders(Integer pageNumber, Integer pageSize) {

        if (pageSize <= 0) {
            pageSize = 0;
        }

        List<OrderEntity> pagedList = new ArrayList<>();
        List<OrderEntity> list = SpringbootessentialsApplication.getOrders();
        int fromIndex = (pageNumber) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, list.size());

        int totalPages = (int) Math.ceil((double) list.size() / pageSize);

        if (fromIndex >= list.size() || fromIndex < 0) {
            return new Pageable<>(List.of(), 0, 0);
        }

        return new Pageable<>(list.subList(fromIndex, toIndex), list.size(), totalPages);
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return SpringbootessentialsApplication.getOrders()
                .stream()
                .filter(orderEntity -> orderEntity.getId().equals(id))
                .findFirst();
    }
    @Override
    public Long updateOrder(OrderEntity order) {

        OrderEntity orderResult = SpringbootessentialsApplication.getOrders()
                .stream()
                .filter(or -> or.getId().equals(order.getId()))
                .findFirst().orElse(new OrderEntity());

        orderResult.setItemName(order.getItemName());
        orderResult.setStatus(order.getStatus());
        return order.getId();
    }

    @Override
    public List<OrderEntity> findSentOrdersByAddressId(Long id) {
        // TODO
        return null;
    }

    @Override
    public Long deleteOrder(Long id) {
        // TODO
        return null;
    }
}
