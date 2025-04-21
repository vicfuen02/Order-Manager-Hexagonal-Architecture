package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.mapper;

import com.springbootessentials.springbootessentials.domain.user.User;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.user.dto.UserReqDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserRestControllerMapper {

    public abstract User toBDTO(UserReqDTO userReqDTO);
}
