package com.springbootessentials.springbootessentials.repository;

import com.springbootessentials.springbootessentials.repository.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {


    @EntityGraph(attributePaths = {"status", "address"})
    Page<OrderEntity> findAll(Pageable page);

    @EntityGraph(attributePaths = {"status", "address"})
    Optional<OrderEntity> findById(Long id);


    @Query(value=
            " SELECT o " +
            " FROM OrderEntity o " +
                    " JOIN FETCH o.address a " +
                    " JOIN FETCH o.status s " +
            " WHERE s.code = 'ORS003' " +
                    " AND a.id = :addressId"
    )
    List<OrderEntity> findSentOrdersByAddressId(@Param("addressId") Long id);

}
