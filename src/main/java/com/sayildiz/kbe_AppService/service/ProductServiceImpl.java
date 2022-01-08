package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getProductList() {
        return repository.findAll();
    }
}
