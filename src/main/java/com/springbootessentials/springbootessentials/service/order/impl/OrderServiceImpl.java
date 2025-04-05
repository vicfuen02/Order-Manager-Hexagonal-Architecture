package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.OrderRepository;
import com.springbootessentials.springbootessentials.repository.dto.OrderEntity;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import com.springbootessentials.springbootessentials.service.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
import com.springbootessentials.springbootessentials.service.order.mapper.OrderServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@LogExecutionSPE
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private OrderServiceMapper orderServiceMapper;
    private OrderServiceCommand orderServiceCommand;
    private OrderAsyncService orderAsyncService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderServiceMapper orderServiceMapper, OrderServiceCommand orderServiceCommand, OrderAsyncService orderAsyncService) {
        this.orderRepository = orderRepository;
        this.orderServiceMapper = orderServiceMapper;
        this.orderServiceCommand = orderServiceCommand;
        this.orderAsyncService = orderAsyncService;
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
        return this.orderServiceCommand.getOrderById(id);
    }

    public Long updateOrder(OrderBDTO order) {
        return this.orderServiceCommand.updateOrder(order);
    }


    public OrderBDTO sendOrder(SendOrderBDTO sendOrder) {

        OrderBDTO order = this.getOrderById(sendOrder.getOrderId());
        order.setStatus(new CodeBDTO.Builder().setCode(OrderSentsEnum.PENDING.getCode()).build());
        this.updateOrder(order);

        this.orderAsyncService.sendOrderAsync(sendOrder);

        return order;
    }





}
