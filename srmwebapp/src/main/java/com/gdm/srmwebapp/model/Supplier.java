package com.gdm.srmwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    @Column(nullable = false, unique = true)
    @NotNull(message = "Supplier is required")
    private Integer supplierNumber;
    @NotBlank(message = "Supplier name is required")
    private String name;
    private String contactPhoneNumber;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products;
}
