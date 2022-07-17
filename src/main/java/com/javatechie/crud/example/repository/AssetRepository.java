package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
    @Query(value = "select exists(select * from asset where lower(asset_name)=lower(:assetType))",nativeQuery = true)
    Long findByAsset(@Param("assetType") String assetType);

}
