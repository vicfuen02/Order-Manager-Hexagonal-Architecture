package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper;

import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.address.dto.AddressReqDTO;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.address.dto.AddressResDTO;
import com.springbootessentials.springbootessentials.domain.address.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AddressRestControllerMapper {

    public abstract List<AddressResDTO> toResDTOList(List<Address> list);
    public abstract Address toBDTO(AddressReqDTO address);

}
