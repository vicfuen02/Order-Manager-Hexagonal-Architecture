package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.order.mock;

import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.OrderServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@LogExecutionSPE
@Component
public class OrderDaoMockAdapter implements OrderDao {


    @Autowired
    private OrderRepositoryMock orderRepository;
    @Autowired
    private OrderServiceMapper orderServiceMapper;



    @Override
    public Long createOrder(Order order) {

        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        return this.orderRepository.createOrder(orderEntity);
    }

    @Override
    public Pageable<Order> getOrders(Integer pageNumber, Integer pageSize) {
        Pageable<OrderEntity> order = this.orderRepository.getOrders(pageNumber, pageSize);
        return this.orderServiceMapper.toOrderPageBDTO(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<OrderEntity> orderEntity =  this.orderRepository.getOrderById(id);
        return orderEntity.map(entity -> this.orderServiceMapper.toBDTO(entity));
    }

    @Override
    public Long updateOrder(Order order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        return this.orderRepository.updateOrder(orderEntity);
    }

    @Override
    public List<Order> findSentOrdersByAddressId(Long id) {
        List<OrderEntity> orders = this.orderRepository.findSentOrdersByAddressId(id);
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }

    @Override
    public Long deleteOrder(Order order) {
        return this.orderRepository.deleteOrder(order.getId());
    }
}
