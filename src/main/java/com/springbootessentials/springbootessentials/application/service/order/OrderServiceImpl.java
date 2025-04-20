package com.springbootessentials.springbootessentials.application.service.order;

import com.springbootessentials.springbootessentials.application.ports.input.order.OrderAsyncService;
import com.springbootessentials.springbootessentials.application.ports.input.order.OrderService;
import com.springbootessentials.springbootessentials.application.ports.input.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.domain.common.Code;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;
import com.springbootessentials.springbootessentials.domain.order.OrderSentsEnum;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.OrderServiceMapper;
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
    public Long createOrder(Order order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        Long orderId = this.orderDao.createOrder(orderEntity);
        return orderId;
    }

    public Pageable<Order> getOrders(Integer pageNumber, Integer pageSize) {
        Pageable<OrderEntity> pageOrders = this.orderDao.getOrders(pageNumber, pageSize);
        return this.orderServiceMapper.toOrderPageBDTO(pageOrders);
    }

    @Override
    public Order getOrderById(Long id) {
        return this.orderServiceCommand.getOrderById(id);
    }

    @Transactional
    public Long updateOrder(Order order) {
        return this.orderServiceCommand.updateOrder(order);
    }


    public Order sendOrder(SendOrder sendOrder) {

        Order order = this.getOrderById(sendOrder.getOrderId());
        order.setStatus(new Code(OrderSentsEnum.PENDING.getCode(), null));
        this.updateOrder(order);

        this.orderAsyncService.sendOrderAsync(sendOrder);

        return this.getOrderById(order.getId());
    }

    @Transactional
    public Long deleteOrder(Long orderId) {

        Order orderEntityDTO = this.orderServiceCommand.getOrderById(orderId);
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(orderEntityDTO);
        this.orderDao.deleteOrder(orderEntity);
        return orderId;
    }

    public List<Order> findSentOrdersByAddressId(Long addressId) {
        List<OrderEntity> orders = this.orderDao.findSentOrdersByAddressId(addressId);
        return this.orderServiceMapper.toOrderListBDTO(orders);
    }





}
