package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.OrderJpaRepository;
import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;
import com.springbootessentials.springbootessentials.service.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import com.springbootessentials.springbootessentials.service.order.enums.OrderSentsEnum;
import com.springbootessentials.springbootessentials.service.order.mapper.OrderServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        OrderEntity orderCreated = this.orderJpaRepository.save(orderEntity);
        return orderCreated.getId();
    }

    public PageBDTO<OrderBDTO> getOrders(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(
                        Sort.Order.desc("itemName"),
                        Sort.Order.desc("status.code")
                ));
        Page<OrderEntity> orders = this.orderJpaRepository.findAll(pageable);
        return this.orderServiceMapper.toOrderPageBDTO(orders);
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

    public List<OrderBDTO> findSentOrdersByAddressId(Long addressId) {
        List<OrderEntity> orders = this.orderJpaRepository.findSentOrdersByAddressId(addressId);
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }





}
