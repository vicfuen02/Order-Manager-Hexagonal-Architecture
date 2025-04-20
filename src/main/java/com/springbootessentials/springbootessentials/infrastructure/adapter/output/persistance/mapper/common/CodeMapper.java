package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.common;


import com.springbootessentials.springbootessentials.domain.common.Code;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.common.CodeEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {



    public abstract CodeEntity toEntity(Code code);

    public abstract Code toBDTO(CodeEntity codeEntity);

}
