package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.address.jpa;

import com.springbootessentials.springbootessentials.application.ports.output.address.AddresDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@LogExecutionSPE
@Component
public class AddressDaoJpaAdapter implements AddresDao {

    @Autowired
    private AddressJpaRepository addressJpaRepository;

    @Override
    public List<AddressEntity> getAddresses() {
        return this.addressJpaRepository.findAll();
    }

    @Override
    public Long createAddress(AddressEntity address) {
        return this.addressJpaRepository.save(address).getId();
    }

    @Override
    public Long updateAddress(AddressEntity address) {
        return this.addressJpaRepository.save(address).getId();
    }

    @Override
    public Long deleteAddress(AddressEntity address) {
        this.addressJpaRepository.delete(address);
        return address.getId();
    }

    @Override
    public Optional<AddressEntity> getAddressById(Long id) {
        return this.addressJpaRepository.findById(id);
    }
}
