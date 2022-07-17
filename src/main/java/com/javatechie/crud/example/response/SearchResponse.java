package com.javatechie.crud.example.response;

import java.math.BigInteger;
import java.util.List;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.model.ProductDTO;

import lombok.Data;

@Data
public class SearchResponse {
    List<ProductDTO> assetList;
	BigInteger assetCount;
}
