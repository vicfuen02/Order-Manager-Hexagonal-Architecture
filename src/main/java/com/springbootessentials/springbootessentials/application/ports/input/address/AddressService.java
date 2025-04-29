package com.springbootessentials.springbootessentials.application.ports.input.address;

import com.springbootessentials.springbootessentials.domain.address.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();
    Long createAddress(Address address);
    Long deleteAddress(Long id);
    Long updateAddress(Address address);

}
