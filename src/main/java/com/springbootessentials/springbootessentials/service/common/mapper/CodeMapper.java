package com.springbootessentials.springbootessentials.service.common.mapper;


import com.springbootessentials.springbootessentials.repository.common.dto.Code;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CodeMapper {



    public Code toEntity(CodeBDTO codeBDTO) {
        if (codeBDTO == null) {
            return null;
        }

        return new Code.Builder()
                .setCode(codeBDTO.getCode())
                .setDesc(codeBDTO.getDesc())
                .build();

    };

    public CodeBDTO toBDTO(Code code) {
        if (code == null) {
            return null;
        }

        return new CodeBDTO.Builder()
                .setCode(code.getCode())
                .setDesc(code.getDesc())
                .build();
    };

}
