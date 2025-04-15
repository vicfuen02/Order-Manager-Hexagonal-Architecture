package com.springbootessentials.springbootessentials.service.common.mapper;


import com.springbootessentials.springbootessentials.repository.common.entity.CodeEntity;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {



    public abstract CodeEntity toEntity(CodeBDTO codeBDTO);

    public abstract CodeBDTO toBDTO(CodeEntity codeEntity);

}
