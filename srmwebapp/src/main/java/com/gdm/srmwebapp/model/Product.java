package com.gdm.srmwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false, unique = true)
    @NotNull(message = "Product is required")
    private Long productNumber;
    @NotBlank(message = "Product name is required")
    private String name;
    private Double unitPrice;
    private Integer quantityInStock;
    private LocalDate dateSupplied;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}
