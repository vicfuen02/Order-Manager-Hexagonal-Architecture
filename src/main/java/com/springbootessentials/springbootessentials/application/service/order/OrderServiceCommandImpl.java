package com.springbootessentials.springbootessentials.application.service.order;

import com.springbootessentials.springbootessentials.application.ports.input.order.OrderServiceCommand;
import com.springbootessentials.springbootessentials.application.service.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import com.springbootessentials.springbootessentials.application.ports.output.order.OrderDao;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.domain.exception.InvalidOrderIdSPEssentialsException;
import com.springbootessentials.springbootessentials.domain.exception.OrderExceptionsEnum;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.OrderServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@LogExecutionSPE
@Service
public class OrderServiceCommandImpl implements OrderServiceCommand {


    private OrderDao orderDao;
    private OrderServiceMapper orderServiceMapper;

    @Autowired
    public OrderServiceCommandImpl(OrderDao orderDao, OrderServiceMapper orderServiceMapper) {
        this.orderDao = orderDao;
        this.orderServiceMapper = orderServiceMapper;
    }


    @Override
    public Order getOrderById(Long id) {

        if (id <= 0) {
            throw new InvalidOrderIdSPEssentialsException();
        }

        OrderEntity orderEntity = this.orderDao.getOrderById(id)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(OrderExceptionsEnum.ORDER_NOT_FOUND));

        return this.orderServiceMapper.toBDTO(orderEntity);
    }


    @Transactional
    public Long updateOrder(Order order) {
        OrderEntity orderEntity = this.orderServiceMapper.toEntity(order);
        Long orderId = this.orderDao.updateOrder(orderEntity);
        return orderId;
    }

}
