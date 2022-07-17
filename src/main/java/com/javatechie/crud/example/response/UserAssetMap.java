package com.javatechie.crud.example.response;

import java.util.List;
import java.util.Optional;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.entity.User;

import lombok.Data;
@Data
public class UserAssetMap {
 private Product product;
private Optional<User> user;
private List<Product> productList;

}