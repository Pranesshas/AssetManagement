package com.javatechie.crud.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.response.DashboardData;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneByEmail(String email);

    @Query(value = "Select distinct(project) from user where active=1",nativeQuery = true)
    List<String> getProjects();

    @Query(value = "Select * from user where project= :project",nativeQuery = true)
    List<User> getUserDetailsAsProjects(@Param("project") String project);

    @Query(value = "select * from user where id=(select assigned_user_id from map where assigned_asset_id=:asset_id and status=1);",nativeQuery = true)
    Optional<User> getUserDetailsPerAssets(@Param("asset_id") Long id);


//     @Query(value = "SELECT o.id as user_id,i.id as asset_id, Concat(o.first_name,' ', o.last_name) as name, o.project, i.make , j.product_type,i.model_no,i.product_number"
//    +" FROM user o JOIN map j On o.id=j.assigned_user_id "
//    + " JOIN product i On i.id =  j.assigned_asset_id where j.status=1 order by j.id  desc;",nativeQuery = true)
//     List<DashboardData> getDashboardData();


    @Query(value = "select count( distinct assigned_asset_id )from map;",nativeQuery = true)
    Long  getTotalMapped();


   

    

   
    
}
