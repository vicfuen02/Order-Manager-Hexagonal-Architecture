package com.springbootessentials.springbootessentials.repository;

import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {


    @EntityGraph(attributePaths = {"status", "address"})
    List<OrderEntity> findAll();

    @EntityGraph(attributePaths = {"status", "address"})
    Optional<OrderEntity> findById(Long id);


    @Query(value=
            "SELECT o " +
            "FROM OrderEntity o " +
                    "JOIN FETCH AddressEntity a ON a.id = o.address.id" +
            "WHERE o.status.code = 'ORS001' " +
                    "AND a.id = :id"
    )
    List<OrderEntity> findSentOrdersByAddressId(Long id, Sort sort);

}
