package com.sayildiz.kbe_AppService.storage_api.service;

import com.sayildiz.kbe_AppService.storage_api.model.ProductInfo;

import java.util.UUID;

public interface StorageService {
    ProductInfo getProductInfo(UUID uuid);
}
