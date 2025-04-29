package com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.repository.address.jpa;

import com.springbootessentials.springbootessentials.application.ports.output.address.AddresDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.domain.address.Address;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.AddressServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@LogExecutionSPE
@Component
public class AddressDaoJpaAdapter implements AddresDao {

    @Autowired
    private AddressJpaRepository addressJpaRepository;

    @Autowired
    private AddressServiceMapper addressServiceMapper;

    @Override
    public List<Address> getAddresses() {
        List<AddressEntity> addresses = this.addressJpaRepository.findAll();
        return this.addressServiceMapper.toBDTOList(addresses);
    }

    @Override
    public Long createAddress(Address address) {
        return this.addressJpaRepository.save(
                this.addressServiceMapper.toEntity(address)
        ).getId();
    }

    @Override
    public Long updateAddress(Address address) {
        return this.addressJpaRepository.save(
                this.addressServiceMapper.toEntity(address)
        ).getId();
    }

    @Override
    public Long deleteAddress(Address address) {
        this.addressJpaRepository.delete(this.addressServiceMapper.toEntity(address));
        return address.getId();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        Optional<AddressEntity> addressEntity = this.addressJpaRepository.findById(id);
        return addressEntity.map(address -> this.addressServiceMapper.toBDTO(address));
    }
}
