package com.app.eCommerce.repository;

import com.app.eCommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

    @Query("SELECT p FROM ProductModel p WHERE p.id=:id")
    ProductModel getProductById(@Param("id") Long id);
}
