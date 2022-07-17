package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.model.ProductDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // Product findByName(String name);
   
    // @Query(value = "Select distinct(product_name) from product where is_available=1 order by id desc",nativeQuery = true)
    // List<String> getAvailableProducts();

    @Query(value = "Select * from product where is_active=1 order by id desc",nativeQuery = true)
    List<Product> getAllAssets();

    @Query(value = "select * from product where id in (select assigned_asset_id from map where assigned_user_id=:userId and status=1)",nativeQuery = true)
   List<Product> getUserDetailsPerAssets(@Param("userId") Long userId);
}

