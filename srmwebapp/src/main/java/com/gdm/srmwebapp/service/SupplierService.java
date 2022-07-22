package com.gdm.srmwebapp.service;

import com.gdm.srmwebapp.model.Supplier;
import com.gdm.srmwebapp.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll(Sort.by("name"));
    }
}
