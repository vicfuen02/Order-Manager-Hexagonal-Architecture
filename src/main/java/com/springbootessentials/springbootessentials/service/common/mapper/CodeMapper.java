package com.springbootessentials.springbootessentials.service.common.mapper;


import com.springbootessentials.springbootessentials.controller.common.mapper.CodeBDTOMapper;
import com.springbootessentials.springbootessentials.repository.common.dto.Code;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {




    public abstract Code toEntity(CodeBDTO codeBDTO);

    public abstract CodeBDTO toBDTO(Code code);

}
