package com.app.eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
////@ToString
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
//    @JsonIgnore
    @JoinColumn(name = "category_id")
    private CategoryModel category;
}

