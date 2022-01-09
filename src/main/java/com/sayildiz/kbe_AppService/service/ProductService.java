package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.model.ProductDetails;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getProductList();
    ProductDetails getProductByUuid(UUID uuid);
}
