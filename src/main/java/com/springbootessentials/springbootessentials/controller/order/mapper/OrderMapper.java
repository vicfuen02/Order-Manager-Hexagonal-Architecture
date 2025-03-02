package com.springbootessentials.springbootessentials.controller.order.mapper;

import com.springbootessentials.springbootessentials.controller.order.dto.CreateOrderReqDTO;
import com.springbootessentials.springbootessentials.controller.order.dto.OrderResDTO;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class OrderMapper {

    public abstract OrderBDTO createOrderReqDTOToOrderBDTO(CreateOrderReqDTO order);

    public abstract List<OrderResDTO> orderBDTOListToOrderResDTO(List<OrderBDTO> order);

}
