package com.springbootessentials.springbootessentials.controller.common.mapper;

import com.springbootessentials.springbootessentials.controller.common.dto.CodeRDTO;
import com.springbootessentials.springbootessentials.service.common.dto.CodeBDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CodeBDTOMapper {
//, builder = @Builder(disableBuilder = false)
//    CodeBDTOMapper INSTANCE = Mappers.getMapper(CodeBDTOMapper.class);

//    @Mapping(target="code", source="code")
//    @Mapping(target="desc", source="desc")
    public CodeRDTO toRDTO(CodeBDTO codeBDTO) {
        if (codeBDTO == null) {
            return null;
        }

        return new CodeRDTO.Builder()
                .setCode(codeBDTO.getCode())
                .setDesc(codeBDTO.getDesc())
                .build();
    };


    public CodeBDTO toBDTO(CodeRDTO codeRDTO) {
        if (codeRDTO == null) {
            return null;
        }

        return new CodeBDTO.Builder()
                .setCode(codeRDTO.getCode())
                .setDesc(codeRDTO.getDesc())
                .build();

    };

}
