package com.springbootessentials.springbootessentials.service.order.mapper;

import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderServiceMapper {

    @Mapping(target = "address.orders", ignore = true)
    public abstract OrderBDTO toBDTO(OrderEntity orderEntity);

    @Named("toBDTOWithoutAddress")
    @Mapping(target = "address", ignore = true)
    public abstract OrderBDTO toBDTOWithoutAddress(OrderEntity orderEntity);
    public abstract List<OrderBDTO> toOrderListBDTO(List<OrderEntity> orderEntity);
    public abstract OrderEntity toEntity(OrderBDTO orderEntity);

}
