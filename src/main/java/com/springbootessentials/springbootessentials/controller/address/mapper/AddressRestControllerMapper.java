package com.springbootessentials.springbootessentials.controller.address.mapper;

import com.springbootessentials.springbootessentials.controller.address.dto.AddressReqDTO;
import com.springbootessentials.springbootessentials.controller.address.dto.AddressResDTO;
import com.springbootessentials.springbootessentials.controller.common.mapper.CodeBDTOMapper;
import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AddressRestControllerMapper {

    public abstract List<AddressResDTO> toResDTOList(List<AddressBDTO> list);
    public abstract AddressBDTO toBDTO(AddressReqDTO address);

}
