package com.springbootessentials.springbootessentials.controller.order.mapper;

import com.springbootessentials.springbootessentials.controller.order.dto.CreateOrderReqDTO;
import com.springbootessentials.springbootessentials.controller.order.dto.OrderResDTO;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderRestControllerMapper {

    public abstract OrderBDTO toBTO(CreateOrderReqDTO order);

    public abstract List<OrderResDTO> orderListToResDTO(List<OrderBDTO> order);
    public abstract OrderResDTO toResDTO(OrderBDTO order);

}
