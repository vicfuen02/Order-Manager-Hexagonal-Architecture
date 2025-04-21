package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.PageResDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper.OrderRestControllerMapper;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.application.ports.input.order.OrderService;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.OrderReqDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.OrderResDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.SendOrderReqDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@LogExecutionSPE
@RequestMapping("/order")
@RestController
public class OrderRestController extends OrderExceptionHandler {

    private static final Logger log = LogManager.getLogger(OrderRestController.class);

    private OrderService orderService;
    private OrderRestControllerMapper orderRestControllerMapper;

    @Autowired
    public OrderRestController(OrderService orderService, OrderRestControllerMapper orderRestControllerMapper) {
        this.orderService = orderService;
        this.orderRestControllerMapper = orderRestControllerMapper;
    }


    @PreAuthorize("hasAnyRole('ADMIN','ROL001')")
    @Cacheable(value={"/order"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", key="#root.target.getCacheKey(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @GetMapping
    public PageResDTO<OrderResDTO> getOrders(
            @RequestParam(name="pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name="pageSize", required = false, defaultValue = "100") Integer pageSize) {

        Pageable<Order> orderList = this.orderService.getOrders(pageNumber, pageSize);
        return this.orderRestControllerMapper.orderPageToResDTO(orderList);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @CacheEvict(value={"/order/create"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries=true)
    @PostMapping
    public Long createOrder(@RequestBody OrderReqDTO order) {

        Order orderBDTO = this.orderRestControllerMapper.toBTO(order);
        return this.orderService.createOrder(orderBDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ROL001')")
    @Cacheable(value={"/order/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", key="#root.target.getCacheKey(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @GetMapping("/{id}")
    public OrderResDTO getOrderById(@PathVariable Long id) {

        Order orderByIdResult = this.orderService.getOrderById(id);
        return this.orderRestControllerMapper.toResDTO(orderByIdResult);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @CacheEvict(value={"/order/{id}/update"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries = true)
//    @CacheEvict(value={"/order/{id}", "/order"}, allEntries = true)
    @PutMapping("/{id}")
    public Long updateOrder(@PathVariable Long id, @RequestBody OrderReqDTO order) {

        order.setId(id);
        Order orderBDTO = this.orderRestControllerMapper.toBTO(order);
        return this.orderService.updateOrder(orderBDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @CacheEvict(value={"/order/delete/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries=true)
    @DeleteMapping("/{id}")
    public Long deleteOrder(@PathVariable Long id) {
        return this.orderService.deleteOrder(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @CacheEvict(value={"/order/sendOrder/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @PostMapping("/sendOrder/{id}")
    public OrderResDTO sendOrder(@PathVariable Long id, @RequestBody SendOrderReqDTO sendOrder) {

        sendOrder.setOrderId(id);
        SendOrder orderBDTO = this.orderRestControllerMapper.toBTO(sendOrder);
        Order res = this.orderService.sendOrder(orderBDTO);
        return this.orderRestControllerMapper.toResDTO(res);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/sentOrders")
    public List<OrderResDTO> findSentOrdersByAddressId(@RequestParam(name="addressId") Long addressId) {
        List<Order> orders = this.orderService.findSentOrdersByAddressId(addressId);
        return this.orderRestControllerMapper.orderListToResDTO(orders);
    }

}
