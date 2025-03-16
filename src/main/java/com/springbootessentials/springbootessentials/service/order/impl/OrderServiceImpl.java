package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.exception.SPEssentialsException;
import com.springbootessentials.springbootessentials.common.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.repository.OrderRepository;
import com.springbootessentials.springbootessentials.repository.dto.OrderEntity;
import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.exceptions.InvalidOrderIdSPEssentialsException;
import com.springbootessentials.springbootessentials.service.order.exceptions.OrderExceptionsEnum;
import com.springbootessentials.springbootessentials.service.order.mapper.OrderServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private OrderServiceMapper orderServiceMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderServiceMapper orderServiceMapper) {
        this.orderRepository = orderRepository;
        this.orderServiceMapper = orderServiceMapper;
    }

    public Long createOrder(OrderBDTO order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        return this.orderRepository.createOrder(orderEntity);
    }

    public List<OrderBDTO> getOrders() {
        List<OrderEntity> orders = this.orderRepository.getOrders();
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }

    @Override
    public OrderBDTO getOrderById(Long id) {

        if (id <= 0) {
            throw new InvalidOrderIdSPEssentialsException();
        }

        OrderEntity orderEntity = this.orderRepository.getOrderById(id)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(OrderExceptionsEnum.ORDER_NOT_FOUND));

        return this.orderServiceMapper.toBDTO(orderEntity);
    }




}
