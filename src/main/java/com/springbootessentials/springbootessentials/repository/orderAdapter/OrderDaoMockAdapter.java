package com.springbootessentials.springbootessentials.repository.orderAdapter;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.OrderRepositoryMock;
import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@LogExecutionSPE
@Component
public class OrderDaoMockAdapter implements OrderDao {


    @Autowired
    private OrderRepositoryMock orderRepository;


    @Override
    public Long createOrder(OrderEntity order) {
        return this.orderRepository.createOrder(order);
    }

    @Override
    public PageBDTO<OrderEntity> getOrders(Integer pageNumber, Integer pageSize) {
        return this.orderRepository.getOrders(pageNumber, pageSize);
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return this.orderRepository.getOrderById(id);
    }

    @Override
    public Long updateOrder(OrderEntity order) {
        return this.orderRepository.updateOrder(order);
    }

    @Override
    public List<OrderEntity> findSentOrdersByAddressId(Long id) {
        return this.orderRepository.findSentOrdersByAddressId(id);
    }

    @Override
    public Long deleteOrder(OrderEntity order) {
        return this.orderRepository.deleteOrder(order.getId());
    }
}
