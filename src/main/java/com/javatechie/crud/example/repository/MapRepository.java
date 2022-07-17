package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatechie.crud.example.entity.Map;

@Repository
public interface MapRepository extends JpaRepository<Map,Long> {
    
    @Query(value = "select id from map where assigned_asset_id=:asset_id and status=1;",nativeQuery = true)
    Long[] checkAssignment(@Param("asset_id") Long id);
}
