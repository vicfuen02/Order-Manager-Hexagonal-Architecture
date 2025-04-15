package com.springbootessentials.springbootessentials.controller.common.mapper;

import com.springbootessentials.springbootessentials.controller.common.dto.CodeRDTO;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CodeBDTOMapper {

    public abstract CodeRDTO toRDTO(CodeBDTO codeBDTO);


    public abstract CodeBDTO toBDTO(CodeRDTO codeRDTO);

}
