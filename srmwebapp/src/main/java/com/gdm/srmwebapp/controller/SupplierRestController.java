package com.gdm.srmwebapp.controller;

import com.gdm.srmwebapp.model.Supplier;
import com.gdm.srmwebapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/srm/api/supplier"})
public class SupplierRestController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping(value={"/list"})
    public ResponseEntity<List<Supplier>> listSuppliers() {
        return ResponseEntity.ok(supplierService.getSuppliers());
    }

}
