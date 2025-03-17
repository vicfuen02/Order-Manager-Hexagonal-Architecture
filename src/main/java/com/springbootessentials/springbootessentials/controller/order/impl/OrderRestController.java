package com.springbootessentials.springbootessentials.controller.order.impl;

import com.springbootessentials.springbootessentials.controller.order.dto.CreateOrderReqDTO;
import com.springbootessentials.springbootessentials.controller.order.dto.OrderResDTO;
import com.springbootessentials.springbootessentials.controller.order.mapper.OrderRestControllerMapper;
import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderRestController extends OrderExceptionHandler {


    private OrderService orderService;
    private OrderRestControllerMapper orderRestControllerMapper;

    @Autowired
    public OrderRestController(OrderService orderService, OrderRestControllerMapper orderRestControllerMapper) {
        this.orderService = orderService;
        this.orderRestControllerMapper = orderRestControllerMapper;
    }

    @Cacheable(value="/order")
    @GetMapping
    public List<OrderResDTO> getOrders() {

        List<OrderBDTO> orderList = this.orderService.getOrders();
        return this.orderRestControllerMapper.orderListToResDTO(orderList);
    }


    @CacheEvict(value={"/order"}, allEntries = true)
    @PostMapping
    public Long createOrder(@RequestBody CreateOrderReqDTO order) {

        OrderBDTO orderBDTO = this.orderRestControllerMapper.toBTO(order);
        return this.orderService.createOrder(orderBDTO);
    }

    @Cacheable(value="/order/{id}")
    @GetMapping("/{id}")
    public OrderResDTO getOrderById(@PathVariable Long id) {

        OrderBDTO orderByIdResult = this.orderService.getOrderById(id);
        return this.orderRestControllerMapper.toResDTO(orderByIdResult);
    }

}
