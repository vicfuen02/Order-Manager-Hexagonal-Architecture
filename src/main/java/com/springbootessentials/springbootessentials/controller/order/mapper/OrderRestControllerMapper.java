package com.springbootessentials.springbootessentials.controller.order.mapper;

import com.springbootessentials.springbootessentials.controller.common.dto.PageResDTO;
import com.springbootessentials.springbootessentials.controller.order.dto.*;
import com.springbootessentials.springbootessentials.service.common.dto.PageBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.OrderBDTO;
import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderRestControllerMapper {

    public abstract OrderBDTO toBTO(OrderReqDTO order);

    public abstract List<OrderResDTO> orderListToResDTO(List<OrderBDTO> order);
    public abstract PageResDTO<OrderResDTO> orderPageToResDTO(PageBDTO<OrderBDTO> order);
    public abstract OrderResDTO toResDTO(OrderBDTO order);
    public abstract SendOrderBDTO toBTO(SendOrderReqDTO order);
    public abstract SendOrderResDTO toResDTO(SendOrderBDTO order);

}
