package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService{
    @Override
    public ProductInfo getProductInfo(UUID uuid) {
        //TODO Consume Storage REST API
        return new ProductInfo();
    }
}
