package com.springbootessentials.springbootessentials.controller.address.impl;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import com.springbootessentials.springbootessentials.controller.address.dto.AddressReqDTO;
import com.springbootessentials.springbootessentials.controller.address.dto.AddressResDTO;
import com.springbootessentials.springbootessentials.controller.address.mapper.AddressRestControllerMapper;
import com.springbootessentials.springbootessentials.service.address.AddressService;
import com.springbootessentials.springbootessentials.service.address.dto.AddressBDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/address")
@RestController
@LogExecutionSPE
public class AddressRestController extends AddressExceptionHandler {


    private AddressService addressService;
    private AddressRestControllerMapper addressRestControllerMapper;

    @Autowired
    public AddressRestController(AddressService addressService, AddressRestControllerMapper addressRestControllerMapper) {
        this.addressService = addressService;
        this.addressRestControllerMapper = addressRestControllerMapper;
    }


    @Cacheable(value={"/address"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", key="#root.target.getCacheKey(#root.caches, #root.target.class.name, #root.method.name, #root.args)")
    @GetMapping
    public List<AddressResDTO> getAll() {
        List<AddressBDTO> addressList = addressService.getAll();
        return addressRestControllerMapper.toResDTOList(addressList);
    }

    @CacheEvict(value={"/address/create"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries=true)
    @PostMapping
    public Long createAddress(@RequestBody AddressReqDTO addressReqDTO) {
        return addressService.createAddress(addressRestControllerMapper.toBDTO(addressReqDTO));
    }


    @CacheEvict(value={"/address/{id}/update"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries = true)
    @PutMapping("/{id}")
    public Long updateAddress(@PathVariable Long id, @RequestBody AddressReqDTO address) {

        address.setId(id);
        AddressBDTO addressBDTO = this.addressRestControllerMapper.toBDTO(address);
        return this.addressService.updateAddress(addressBDTO);
    }

    @CacheEvict(value={"/address/delete/{id}"}, condition="#root.target.isCacheEnabled(#root.caches, #root.target.class.name, #root.method.name, #root.args)", allEntries=true)
    @DeleteMapping("/{id}")
    public Long deleteAddress(@PathVariable Long id) {
        return this.addressService.deleteAddress(id);
    }

}
