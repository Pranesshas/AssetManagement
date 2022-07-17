package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.model.ProductDTO;
import com.javatechie.crud.example.response.OperationResponse;
import com.javatechie.crud.example.response.ResponseStatusEnum;
import com.javatechie.crud.example.response.SearchResponse;
import com.javatechie.crud.example.response.UserAssetMap;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addAssets")
    public boolean addProduct(@RequestBody ProductDTO product) {
        // System.out.println(product);
        // return true;
        return  service.saveProduct(product);
    }

    @DeleteMapping("/delete/{asset_id}")
    public OperationResponse deleteAsset(@PathVariable Long asset_id) {
        
        boolean assetDeleteSuccess= service.deleteAsset(asset_id);
        OperationResponse resp = new OperationResponse();
		if (assetDeleteSuccess == true) {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("Asset Deleted");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to delete Asset");
		}
		return resp;
    }


    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    // @GetMapping("/productById/{id}")
    // public Product findProductById(@PathVariable int id) {
    //     return service.getProductById(id);
    // }

    @GetMapping("/available")
    public List<Product> findAvailableProduct() {
        return service.getAvailableProducts();
    }
    // @GetMapping("/product/{name}")
    // public Product findProductByName(@PathVariable String name) {
    //     return service.getProductByName(name);
    // }
    @RequestMapping(value = "/asset/search/{startPosition}")
    public SearchResponse searchUsersPagination(@PathVariable("startPosition") Integer startPosition,@RequestBody ProductDTO productDTO) {
        return service.searchUsersPagination(productDTO,startPosition);
    }

    //properly working stuff
    // @GetMapping(value = "/get/{assetId}")   
    // public Product getProductById(@PathVariable("assetId") Long assetId){
    //     return service.getProductById(assetId);
    // }
    // @PutMapping("/update")
    // public Product updateProduct(@RequestBody Product product) {
    //     return service.updateProduct(product);
    // }

    // @DeleteMapping("/delete/{id}")
    // public String deleteProduct(@PathVariable Long id) {
    //     return service.deleteProduct(id);
    // }



    @GetMapping(value = "/get/{assetId}")   
    public UserAssetMap getProductById(@PathVariable("assetId") Long assetId){
        return service.getProductById(assetId);
    }


    @GetMapping(value = "/getAssets/{userId}")   
    public UserAssetMap getAssetsByUserId(@PathVariable("userId") Long userId){
        return service.getAssetsByUserId(userId);
    }
}
