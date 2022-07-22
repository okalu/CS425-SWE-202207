package com.gdm.srmwebapp.controller;

import com.gdm.srmwebapp.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"srm/supplier"})
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/list"})
    public String listSuppliers(Model model) {
        var suppliers = supplierService.getSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "supplier/list";
    }
}
