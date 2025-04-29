package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.jpa;

import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.OrderServiceMapper;
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

    @Autowired
    private OrderServiceMapper orderServiceMapper;

    @Override
    public Long createOrder(Order order) {

        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        return this.orderJpaRepository.save(orderEntity).getId();
    }

    @Override
    public Pageable<Order> getOrders(Integer pageNumber, Integer pageSize) {
        org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(
                        Sort.Order.desc("itemName"),
                        Sort.Order.desc("status.code")
                ));
        Page<OrderEntity> orders = this.orderJpaRepository.findAll(pageable);
        return this.orderServiceMapper.toOrderPageBDTO(new Pageable<>(orders));
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<OrderEntity> orderEntity = this.orderJpaRepository.findById(id);
        return orderEntity.map(entity -> this.orderServiceMapper.toBDTO(entity));

    }

    @Override
    public Long updateOrder(Order order) {

        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        return this.orderJpaRepository.save(orderEntity).getId();
    }

    @Override
    public List<Order> findSentOrdersByAddressId(Long id) {
        List<OrderEntity> orders = this.orderJpaRepository.findSentOrdersByAddressId(id);
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }

    @Override
    public Long deleteOrder(Order order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        this.orderJpaRepository.delete(orderEntity);
        return order.getId();
    }
}
