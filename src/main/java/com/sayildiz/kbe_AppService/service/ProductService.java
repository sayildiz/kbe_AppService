package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.ProductDTO;
import com.sayildiz.kbe_AppService.model.ProductDetails;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDTO> getProductList();
    ProductDetails getProductByUuid(UUID uuid);
}
