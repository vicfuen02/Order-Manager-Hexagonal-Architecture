package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.address.jpa;

import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {


    @EntityGraph(attributePaths = {"orders", "orders.status"})
    List<AddressEntity> findAll();

}
