package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper;

import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderServiceMapper {

    @Mapping(target = "address.orders", ignore = true)
    public abstract Order toBDTO(OrderEntity orderEntity);

    @Named("toBDTOWithoutAddress")
    @Mapping(target = "address", ignore = true)
    public abstract Order toBDTOWithoutAddress(OrderEntity orderEntity);
    public abstract List<Order> toOrderListBDTO(List<OrderEntity> orderEntity);
    public Pageable<Order> toOrderPageBDTO(Pageable<OrderEntity> orderEntity) {
        return new Pageable<>(
                this.toOrderListBDTO(orderEntity.getContent()),
                orderEntity.getTotalElements(),
                orderEntity.getTotalPages()
        );
    };

    public abstract OrderEntity toEntity(Order orderEntity);

}
