package com.javatechie.crud.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Map;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.model.MapDTO;
import com.javatechie.crud.example.repository.MapRepository;
import com.javatechie.crud.example.repository.ProductRepository;
import com.javatechie.crud.example.repository.UserRepository;

@Service
public class MapService {
    
    @Autowired
    MapRepository mapRepo;

    // @Autowired
    // Product product;



    @Autowired
    ProductRepository productRepo;

    @Autowired
    UserRepository userRepo;

    public boolean saveMap(MapDTO mapDTO){
        if(mapDTO.getAsset_id()==0L || mapDTO.getAsset_type()=="" || mapDTO.getUser_id()==0L){
            return false;
        } 

        // check if the asset is reassigned
        Long [] arr = mapRepo.checkAssignment(mapDTO.getAsset_id());
        boolean value=false;
        if ( arr.length!=0 && arr[0]!=mapDTO.getUser_id()){
             value=reassignUser(arr);
        }

        //first operation - change availablity to zero for asset
        
        try{
       Product product=productRepo.findById(mapDTO.getAsset_id()).get();
       if(!value){
       product.set_available(false);
       }
       productRepo.save(product);
        
           
       //second operation
    //    if(!value && !productRepo.getOne(mapDTO.getAsset_id()).is_available())
        
        Map map = new Map();
        map.setProduct(product);
        // map.setAsset(product.getProduct_type());
        map.setProduct_type(product.getProduct_type());
        
        map.setUser(userRepo.getOne(mapDTO.getUser_id()));
       mapRepo.save(map);
       return true;
       
        }
        catch(Exception e)
        {
            return false;
        }

        // return false ;

    }

    public boolean reassignUser(Long[] arr){
        
        for(Long id : arr){
           Map map = mapRepo.findById(id).get();
           if( map.isStatus()){
            map.setStatus(false);
            mapRepo.save(map);
           }
            
    }
    return true;
    
}

    public boolean unassignUserMap(MapDTO mapDTO) {
        Long [] arr = mapRepo.checkAssignment(mapDTO.getAsset_id());
        boolean value=false;
        if ( arr.length!=0 && arr[0]!=mapDTO.getUser_id()){
             value=reassignUser(arr);
        }
        if(value){
            Product product = productRepo.findById(mapDTO.getAsset_id()).get();
            product.set_available(true);
            productRepo.save(product);


        }
       
        return true;

    }
}
