package com.springbootessentials.springbootessentials.controller.order.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.controller.order.dto.*;
import com.springbootessentials.springbootessentials.controller.order.mapper.OrderRestControllerMapper;
import com.springbootessentials.springbootessentials.service.order.OrderService;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
@LogExecutionSPE
public class OrderRestController extends OrderExceptionHandler {

    private static final Logger log = LogManager.getLogger(OrderRestController.class);

    private OrderService orderService;
    private OrderRestControllerMapper orderRestControllerMapper;

    @Autowired
    public OrderRestController(OrderService orderService, OrderRestControllerMapper orderRestControllerMapper) {
        this.orderService = orderService;
        this.orderRestControllerMapper = orderRestControllerMapper;
    }


    @Cacheable(value={"/order"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", key="#root.target.getCacheKey(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @GetMapping
    public List<OrderResDTO> getOrders() {

        List<OrderBDTO> orderList = this.orderService.getOrders();
        return this.orderRestControllerMapper.orderListToResDTO(orderList);
    }

    @CacheEvict(value={"/order/create"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries=true)
    @PostMapping
    public Long createOrder(@RequestBody CreateOrderReqDTO order) {

        OrderBDTO orderBDTO = this.orderRestControllerMapper.toBTO(order);
        return this.orderService.createOrder(orderBDTO);
    }

    @Cacheable(value={"/order/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", key="#root.target.getCacheKey(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @GetMapping("/{id}")
    public OrderResDTO getOrderById(@PathVariable Long id) {

        OrderBDTO orderByIdResult = this.orderService.getOrderById(id);
        return this.orderRestControllerMapper.toResDTO(orderByIdResult);
    }

    @CacheEvict(value={"/order/{id}/update"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries = true)
//    @CacheEvict(value={"/order/{id}", "/order"}, allEntries = true)
    @PutMapping("/{id}")
    public Long updateOrder(@PathVariable Long id, @RequestBody UpdateOrderReqDTO order) {

        order.setId(id);
        OrderBDTO orderBDTO = this.orderRestControllerMapper.toBTO(order);
        return this.orderService.updateOrder(orderBDTO);
    }


    @CacheEvict(value={"/order/sendOrder/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @PostMapping("/sendOrder/{id}")
    public OrderResDTO sendOrder(@PathVariable Long id, @RequestBody SendOrderReqDTO sendOrder) {

        sendOrder.setOrderId(id);
        SendOrderBDTO orderBDTO = this.orderRestControllerMapper.toBTO(sendOrder);
        OrderBDTO res = this.orderService.sendOrder(orderBDTO);
        return this.orderRestControllerMapper.toResDTO(res);
    }

}
