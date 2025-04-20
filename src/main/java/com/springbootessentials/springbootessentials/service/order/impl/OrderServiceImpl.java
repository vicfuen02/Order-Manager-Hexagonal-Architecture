package com.springbootessentials.springbootessentials.service.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.repository.orderAdapter.OrderDao;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@LogExecutionSPE
public class OrderServiceImpl implements OrderService {


    private OrderServiceMapper orderServiceMapper;
    private OrderServiceCommand orderServiceCommand;
    private OrderAsyncService orderAsyncService;
    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderServiceMapper orderServiceMapper, OrderServiceCommand orderServiceCommand, OrderAsyncService orderAsyncService) {
        this.orderDao = orderDao;
        this.orderServiceMapper = orderServiceMapper;
        this.orderServiceCommand = orderServiceCommand;
        this.orderAsyncService = orderAsyncService;
    }

    @Transactional
    public Long createOrder(OrderBDTO order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        Long orderId = this.orderDao.createOrder(orderEntity);
        return orderId;
    }

    public PageBDTO<OrderBDTO> getOrders(Integer pageNumber, Integer pageSize) {
        PageBDTO<OrderEntity> pageOrders = this.orderDao.getOrders(pageNumber, pageSize);
        return this.orderServiceMapper.toOrderPageBDTO(pageOrders);
    }

    @Override
    public OrderBDTO getOrderById(Long id) {
        return this.orderServiceCommand.getOrderById(id);
    }

    @Transactional
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

    @Transactional
    public Long deleteOrder(Long orderId) {

        OrderBDTO orderEntityDTO = this.orderServiceCommand.getOrderById(orderId);
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(orderEntityDTO);
        this.orderDao.deleteOrder(orderEntity);
        return orderId;
    }

    public List<OrderBDTO> findSentOrdersByAddressId(Long addressId) {
        List<OrderEntity> orders = this.orderDao.findSentOrdersByAddressId(addressId);
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }





}
