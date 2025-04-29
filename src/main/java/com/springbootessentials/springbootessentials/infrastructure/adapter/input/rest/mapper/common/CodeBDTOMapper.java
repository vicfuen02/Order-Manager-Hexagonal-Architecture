package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper.common;

import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.CodeRDTO;
import com.springbootessentials.springbootessentials.domain.common.Code;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CodeBDTOMapper {

    public abstract CodeRDTO toRDTO(Code code);


    public abstract Code toBDTO(CodeRDTO codeRDTO);

}
