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

    @Autowired
    public OrderServiceCommandImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public Order getOrderById(Long id) {

        if (id <= 0) {
            throw new InvalidOrderIdSPEssentialsException();
        }

        Order orderEntity = this.orderDao.getOrderById(id)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(OrderExceptionsEnum.ORDER_NOT_FOUND));

        return orderEntity;
    }


    @Transactional
    public Long updateOrder(Order order) {
        Long orderId = this.orderDao.updateOrder(order);
        return orderId;
    }

}
