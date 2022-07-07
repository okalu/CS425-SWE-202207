package edu.miu.cs.cs425.fairfieldlibrarywebapi.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.PrimaryAddress;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.repository.PrimaryAddressRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapi.service.PrimaryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimaryAddressServiceImpl implements PrimaryAddressService {

    @Autowired
    private PrimaryAddressRepository primaryAddressRepository;

    @Override
    public PrimaryAddress addNewPrimaryAddress(PrimaryAddress primaryAddress) {
        return primaryAddressRepository.save(primaryAddress);
    }
}
