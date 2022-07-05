package edu.miu.cs.cs425.fairfieldlibrarycliapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.PrimaryAddress;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.repository.PrimaryAddressRepository;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.service.PrimaryAddressService;
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
