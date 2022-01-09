package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.ProductInfo;

import java.util.UUID;

public interface StorageService {
    ProductInfo getProductInfo(UUID uuid);
}
