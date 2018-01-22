package com.oguzhanuzman.github.gardirop.persistence;

import com.oguzhanuzman.github.gardirop.persistence.base.SoftDeletableAuditableUniqueEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends SoftDeletableAuditableUniqueEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;
    @ManyToOne(optional = false)
    private ProductCategory category;

    public Product(String name, BigDecimal price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}