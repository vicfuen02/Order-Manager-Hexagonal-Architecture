package com.springbootessentials.springbootessentials.repository.orderAdapter;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.repository.OrderJpaRepository;
import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@LogExecutionSPE
@Component
public class OrderDaoJpaAdapter implements OrderDao {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Override
    public Long createOrder(OrderEntity order) {
        return this.orderJpaRepository.save(order).getId();
    }

    @Override
    public PageBDTO<OrderEntity> getOrders(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(
                        Sort.Order.desc("itemName"),
                        Sort.Order.desc("status.code")
                ));
        Page<OrderEntity> orders = this.orderJpaRepository.findAll(pageable);
        return new PageBDTO<>(orders);
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return this.orderJpaRepository.findById(id);
    }

    @Override
    public Long updateOrder(OrderEntity order) {
        return this.orderJpaRepository.save(order).getId();
    }

    @Override
    public List<OrderEntity> findSentOrdersByAddressId(Long id) {
        return this.orderJpaRepository.findSentOrdersByAddressId(id);
    }

    @Override
    public Long deleteOrder(OrderEntity order) {
        this.orderJpaRepository.delete(order);
        return order.getId();
    }
}
