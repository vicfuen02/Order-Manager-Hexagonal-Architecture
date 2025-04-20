package com.springbootessentials.springbootessentials.application.ports.output.address;

import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

public interface AddresDao {


    List<AddressEntity> getAddresses();

    Long createAddress(AddressEntity address);
    Long updateAddress(AddressEntity address);
    Long deleteAddress(AddressEntity address);

    Optional<AddressEntity> getAddressById(Long id);

}
