package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper;

import com.springbootessentials.springbootessentials.domain.address.Address;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring"
        ,uses={OrderServiceMapper.class}
)
public abstract class AddressServiceMapper {


    public abstract List<Address> toBDTOList(List<AddressEntity> list);

    public abstract AddressEntity toEntity(Address address);

    @Mapping(target = "orders", qualifiedByName="toBDTOWithoutAddress")
    public abstract Address toBDTO(AddressEntity address);

}
