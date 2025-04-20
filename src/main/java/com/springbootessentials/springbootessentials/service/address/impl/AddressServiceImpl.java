package com.springbootessentials.springbootessentials.service.address.impl;

import com.springbootessentials.springbootessentials.common.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.repository.AddressJpaRepository;
import com.springbootessentials.springbootessentials.repository.entity.AddressEntity;
import com.springbootessentials.springbootessentials.service.address.AddressService;
import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;
import com.springbootessentials.springbootessentials.service.address.exceptions.AddressExceptionsEnum;
import com.springbootessentials.springbootessentials.service.address.mapper.AddressServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {


    private AddressJpaRepository addressJpaRepository;
    private AddressServiceMapper addressServiceMapper;


    @Autowired
    public AddressServiceImpl(AddressJpaRepository addressJpaRepository, AddressServiceMapper addressServiceMapper) {
        this.addressJpaRepository = addressJpaRepository;
        this.addressServiceMapper = addressServiceMapper;
    }

    @Override
    public List<AddressBDTO> getAll() {
        List<AddressEntity> addressList = this.addressJpaRepository.findAll();
        return this.addressServiceMapper.toBDTOList(addressList);
    }

    @Transactional
    @Override
    public Long createAddress(AddressBDTO address) {
        return this.addressJpaRepository.save(
                this.addressServiceMapper.toEntity(address)
        ).getId();
    }

    @Transactional
    @Override
    public Long deleteAddress(Long id) {
        AddressEntity address = this.addressJpaRepository.findById(id)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(AddressExceptionsEnum.ADDRESS_NOT_FOUND));
        this.addressJpaRepository.delete(address);
        return id;
    }

    @Transactional
    @Override
    public Long updateAddress(AddressBDTO address) {
        return this.addressServiceMapper.toBDTO(
                this.addressJpaRepository.save(
                        this.addressServiceMapper.toEntity(address)
                )
        ).getId();
    }
}
