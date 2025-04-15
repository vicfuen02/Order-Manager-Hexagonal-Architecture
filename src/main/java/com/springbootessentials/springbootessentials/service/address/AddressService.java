package com.springbootessentials.springbootessentials.service.address;

import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;

import java.util.List;

public interface AddressService {

    List<AddressBDTO> getAll();
    Long createAddress(AddressBDTO address);
    Long deleteAddress(Long id);
    Long updateAddress(AddressBDTO address);

}
