package com.app.eCommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class CategoryModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductModel> productModelSet;

    public CategoryModel(String name) {
        this.name = name;
    }

}
