package com.springbootessentials.springbootessentials.application.ports.output.address;

import com.springbootessentials.springbootessentials.domain.address.Address;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

public interface AddresDao {


    List<Address> getAddresses();

    Long createAddress(Address address);
    Long updateAddress(Address address);
    Long deleteAddress(Address address);

    Optional<Address> getAddressById(Long id);

}
