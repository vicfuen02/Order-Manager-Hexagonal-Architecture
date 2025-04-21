package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.user.jpa;

import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
