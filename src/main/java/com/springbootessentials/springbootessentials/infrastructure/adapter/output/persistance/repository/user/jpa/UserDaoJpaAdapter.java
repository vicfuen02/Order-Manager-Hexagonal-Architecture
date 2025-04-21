package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.user.jpa;

import com.springbootessentials.springbootessentials.application.ports.output.user.UserDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.user.User;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.UserEntity;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@LogExecutionSPE
@Component
public class UserDaoJpaAdapter implements UserDao {


    private UserJpaRepository userJpaRepository;

    private UserServiceMapper userServiceMapper;

    @Autowired
    public UserDaoJpaAdapter(UserJpaRepository userJpaRepository, UserServiceMapper userServiceMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userServiceMapper = userServiceMapper;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userEntity = this.userJpaRepository.findByUsername(username);
        if (userEntity.isEmpty()) {
            return Optional.empty();
        }
        User user = this.userServiceMapper.toBDTO(userEntity.get());
        return Optional.of(user);
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = this.userServiceMapper.toEntity(user);
        UserEntity userEntityCreated = this.userJpaRepository.save(userEntity);
        User userCreated = this.userServiceMapper.toBDTO(userEntityCreated);
        return userCreated;
    }
}
