package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper;

import com.springbootessentials.springbootessentials.domain.user.User;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserServiceMapper {

    @Mapping(target = "address.orders", ignore = true)
    public abstract UserEntity toEntity(User user);

    @Mapping(target = "address.orders", ignore = true)
    public abstract User toBDTO(UserEntity userEntity);

}
