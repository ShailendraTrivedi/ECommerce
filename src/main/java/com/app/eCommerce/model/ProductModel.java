package com.app.eCommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private String description;
    private String imgUrl;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryModel category;
}

