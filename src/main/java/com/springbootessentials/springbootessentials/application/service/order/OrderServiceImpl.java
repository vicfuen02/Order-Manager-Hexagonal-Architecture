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


@LogExecutionSPE
@Service
public class OrderServiceImpl implements OrderService {



    private OrderServiceCommand orderServiceCommand;
    private OrderAsyncService orderAsyncService;
    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderServiceCommand orderServiceCommand, OrderAsyncService orderAsyncService) {
        this.orderDao = orderDao;
        this.orderServiceCommand = orderServiceCommand;
        this.orderAsyncService = orderAsyncService;
    }

    @Transactional
    public Long createOrder(Order order) {
        Long orderId = this.orderDao.createOrder(order);
        return orderId;
    }

    public Pageable<Order> getOrders(Integer pageNumber, Integer pageSize) {
        Pageable<Order> pageOrders = this.orderDao.getOrders(pageNumber, pageSize);
        return pageOrders;
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

        Order orderById = this.orderServiceCommand.getOrderById(orderId);
        this.orderDao.deleteOrder(orderById);
        return orderId;
    }

    public List<Order> findSentOrdersByAddressId(Long addressId) {
        List<Order> orders = this.orderDao.findSentOrdersByAddressId(addressId);
        return orders;
    }





}
