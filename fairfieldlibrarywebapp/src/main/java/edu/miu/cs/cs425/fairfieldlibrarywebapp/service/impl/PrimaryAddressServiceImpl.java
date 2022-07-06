package edu.miu.cs.cs425.fairfieldlibrarywebapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.PrimaryAddress;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.repository.PrimaryAddressRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PrimaryAddressService;
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
