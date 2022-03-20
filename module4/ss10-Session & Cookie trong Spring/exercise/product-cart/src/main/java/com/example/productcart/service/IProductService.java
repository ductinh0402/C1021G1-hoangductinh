package com.example.productcart.service;


import com.example.productcart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();


    Optional<Product> findById(Long id);

    void deleteById(Long id);
}
