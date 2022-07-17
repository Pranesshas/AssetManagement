package com.javatechie.crud.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Asset;
import com.javatechie.crud.example.repository.AssetRepository;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepo;


    public boolean saveAssetType(String assetType){
        Asset asset=new Asset();
        Long check=assetRepo.findByAsset(assetType);
        if(check==0){
        asset.setName(assetType);
        assetRepo.save(asset);
        return true;
        }
        return false;
    }

    public List<Asset> getAssetType(){
        List<Asset> list=new ArrayList<Asset>();
        list=assetRepo.findAll();
        return list;
    }
    
}
