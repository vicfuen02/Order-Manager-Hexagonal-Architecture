package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper;

import com.springbootessentials.springbootessentials.domain.order.Order;
import com.springbootessentials.springbootessentials.domain.order.SendOrder;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.PageResDTO;
import com.springbootessentials.springbootessentials.domain.common.Pageable;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.OrderReqDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.OrderResDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.SendOrderReqDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.order.dto.SendOrderResDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderRestControllerMapper {

    public abstract Order toBTO(OrderReqDTO order);

    public abstract List<OrderResDTO> orderListToResDTO(List<Order> order);
    public abstract PageResDTO<OrderResDTO> orderPageToResDTO(Pageable<Order> order);
    public abstract OrderResDTO toResDTO(Order order);
    public abstract SendOrder toBTO(SendOrderReqDTO order);
    public abstract SendOrderResDTO toResDTO(SendOrder order);

}
