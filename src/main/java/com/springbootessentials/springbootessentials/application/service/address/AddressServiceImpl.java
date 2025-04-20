package com.springbootessentials.springbootessentials.application.service.address;

import com.springbootessentials.springbootessentials.application.ports.input.address.AddressService;
import com.springbootessentials.springbootessentials.application.ports.output.address.AddresDao;
import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.application.service.exception.SPEssentialsExceptionFactory;
import com.springbootessentials.springbootessentials.domain.address.Address;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.entity.AddressEntity;
import com.springbootessentials.springbootessentials.domain.exception.AddressExceptionsEnum;
import com.springbootessentials.springbootessentials.infrastructure.adapter.output.persistance.mapper.AddressServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@LogExecutionSPE
@Service
public class AddressServiceImpl implements AddressService {


    private AddresDao addresDao;
    private AddressServiceMapper addressServiceMapper;


    @Autowired
    public AddressServiceImpl(AddresDao addresDao, AddressServiceMapper addressServiceMapper) {
        this.addresDao = addresDao;
        this.addressServiceMapper = addressServiceMapper;
    }

    @Override
    public List<Address> getAll() {
        List<AddressEntity> addressList = this.addresDao.getAddresses();
        return this.addressServiceMapper.toBDTOList(addressList);
    }

    @Transactional
    @Override
    public Long createAddress(Address address) {
        return this.addresDao.createAddress(
                this.addressServiceMapper.toEntity(address)
        );
    }

    @Transactional
    @Override
    public Long deleteAddress(Long id) {
        AddressEntity address = this.addresDao.getAddressById(id)
                .orElseThrow(() -> SPEssentialsExceptionFactory.throwException(AddressExceptionsEnum.ADDRESS_NOT_FOUND));
        this.addresDao.deleteAddress(address);
        return id;
    }

    @Transactional
    @Override
    public Long updateAddress(Address address) {
        return this.addresDao.updateAddress(
                        this.addressServiceMapper.toEntity(address)
                );
    }
}
