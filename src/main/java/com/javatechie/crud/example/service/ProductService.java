package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Asset;
import com.javatechie.crud.example.entity.Map;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.model.ProductDTO;
import com.javatechie.crud.example.repository.AssetRepository;
import com.javatechie.crud.example.repository.MapRepository;
import com.javatechie.crud.example.repository.ProductRepository;
import com.javatechie.crud.example.repository.UserRepository;
import com.javatechie.crud.example.repository.custom.cProductRepo;
import com.javatechie.crud.example.response.OperationResponse;
import com.javatechie.crud.example.response.SearchResponse;
import com.javatechie.crud.example.response.UserAssetMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private cProductRepo cproductRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AssetRepository assetRepo;

    public boolean saveProduct(ProductDTO productDTO) {
        // return repository.save(product);
        
        Asset asset=assetRepo.getOne(productDTO.getProduct_type());
        if(asset!=null){
            Product product=new Product();
            product.setCd_rom(productDTO.getCd_rom());
            // product.setDate(productDTO.getDate().toInstant());
            product.setHdd(productDTO.getHdd());
            product.setLaptop_number(productDTO.getLaptop_number());
            product.setMake(productDTO.getMake());
            product.setModel_no(productDTO.getModel_no());
            product.setOs(productDTO.getOs());
            product.setProcessor(productDTO.getProcessor());
            product.setProduct_number(productDTO.getProduct_number());
            product.setProduct_type(asset);
            product.setRam(productDTO.getRam());
            product.setNote(productDTO.getNote());
            product.setAsset_number(productDTO.getAsset_number());
            repository.save(product);
            return true;

            
        } 
        return false;
        
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public UserAssetMap getProductById(Long assetId) {
        Product product=repository.findById(assetId).orElse(null);
        UserAssetMap userAssets= new UserAssetMap();
        userAssets.setProduct(product);
        if(product!=null){
            if(!product.is_available()){
               userAssets.setUser(userRepo.getUserDetailsPerAssets(assetId));
                }
            
            }

            return userAssets;

        
        
    }

    // public Product getProductByName(String name) {
    //     return repository.findByName(name);
    // }

    // public String deleteProduct(int id) {
    //     repository.deleteById(id);
    //     return "product removed !! " + id;
    // }

    public List<Product> getAvailableProducts(){
        return repository.getAllAssets();
    }
    // public Product updateProduct(Product product) {
    //     Product existingProduct = repository.findById(product.getId()).orElse(null);
    //     existingProduct.setName(product.getName());
    //     existingProduct.setQuantity(product.getQuantity());
    //     existingProduct.setPrice(product.getPrice());
    //     return repository.save(existingProduct);
    // }

    public Product getProductbyId(Long assetId){
        return repository.findById(assetId).get();
    }

    public boolean deleteAsset(Long asset_id){
        Product product=repository.findById(asset_id).orElse(null);
        if(product.is_available()){
            product.set_active(false);
            repository.save(product);
            return true;
        }

        return false;

    }

    public SearchResponse searchUsersPagination(ProductDTO productDTO,Integer startPosition){

        return cproductRepo.getAllUsersPagination(productDTO, startPosition);

    }

    public UserAssetMap getAssetsByUserId(Long userId) {
        List<Product> product=repository.getUserDetailsPerAssets(userId);
        UserAssetMap userAssets= new UserAssetMap();
        userAssets.setProductList(product);
        userAssets.setUser(userRepo.findById(userId));

        

            return userAssets;

        
        
    }

}
