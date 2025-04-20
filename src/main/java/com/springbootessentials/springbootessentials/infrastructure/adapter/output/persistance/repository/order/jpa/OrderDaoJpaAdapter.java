package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.jpa;

import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@LogExecutionSPE
@Component
public class OrderDaoJpaAdapter implements OrderDao {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Override
    public Long createOrder(OrderEntity order) {
        return this.orderJpaRepository.save(order).getId();
    }

    @Override
    public Pageable<OrderEntity> getOrders(Integer pageNumber, Integer pageSize) {
        org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(
                        Sort.Order.desc("itemName"),
                        Sort.Order.desc("status.code")
                ));
        Page<OrderEntity> orders = this.orderJpaRepository.findAll(pageable);
        return new Pageable<>(orders);
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return this.orderJpaRepository.findById(id);
    }

    @Override
    public Long updateOrder(OrderEntity order) {
        return this.orderJpaRepository.save(order).getId();
    }

    @Override
    public List<OrderEntity> findSentOrdersByAddressId(Long id) {
        return this.orderJpaRepository.findSentOrdersByAddressId(id);
    }

    @Override
    public Long deleteOrder(OrderEntity order) {
        this.orderJpaRepository.delete(order);
        return order.getId();
    }
}
