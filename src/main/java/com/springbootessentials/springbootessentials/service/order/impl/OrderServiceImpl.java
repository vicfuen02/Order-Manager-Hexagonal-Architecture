package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.OrderJpaRepository;
import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
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


//    private OrderRepositoryMock orderRepository;
    private OrderServiceMapper orderServiceMapper;
    private OrderServiceCommand orderServiceCommand;
    private OrderAsyncService orderAsyncService;
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    public OrderServiceImpl(OrderJpaRepository orderJpaRepository, /*OrderRepositoryMock orderRepository,*/ OrderServiceMapper orderServiceMapper, OrderServiceCommand orderServiceCommand, OrderAsyncService orderAsyncService) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderServiceMapper = orderServiceMapper;
        this.orderServiceCommand = orderServiceCommand;
        this.orderAsyncService = orderAsyncService;
    }


    public Long createOrder(OrderBDTO order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
//        return this.orderRepository.createOrder(orderEntity);

        OrderEntity orderCreated = this.orderJpaRepository.save(orderEntity);
        return orderCreated.getId();
    }

    public List<OrderBDTO> getOrders() {
//        List<OrderEntity> orders = this.orderRepository.getOrders();
        List<OrderEntity> orders = this.orderJpaRepository.findAll();
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
        order.setStatus(new CodeBDTO(OrderSentsEnum.PENDING.getCode(), null));
        this.updateOrder(order);

        this.orderAsyncService.sendOrderAsync(sendOrder);

        return this.getOrderById(order.getId());
    }

    public Long deleteOrder(Long orderId) {

        OrderBDTO orderEntityDTO = this.orderServiceCommand.getOrderById(orderId);
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(orderEntityDTO);
        this.orderJpaRepository.delete(orderEntity);
        return orderId;
    }





}
