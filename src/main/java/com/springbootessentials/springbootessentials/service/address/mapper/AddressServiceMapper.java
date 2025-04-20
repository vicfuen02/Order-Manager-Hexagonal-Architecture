package com.springbootessentials.springbootessentials.service.address.mapper;

import com.springbootessentials.springbootessentials.repository.entity.AddressEntity;
import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;
import com.springbootessentials.springbootessentials.service.order.mapper.OrderServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring"
        ,uses={OrderServiceMapper.class}
)
public abstract class AddressServiceMapper {


    public abstract List<AddressBDTO> toBDTOList(List<AddressEntity> list);

    public abstract AddressEntity toEntity(AddressBDTO address);

    @Mapping(target = "orders", qualifiedByName="toBDTOWithoutAddress")
    public abstract AddressBDTO toBDTO(AddressEntity address);

}
