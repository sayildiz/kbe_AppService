package com.sayildiz.kbe_AppService.storage_api.service;

import com.sayildiz.kbe_AppService.storage_api.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService{

    @Value("${storage.host}")
    private String storageHost;

    @Value("${storage.port}")
    private String storagePort;

    @Value("${storage.productInfoAPI}")
    private String storageProductInfoAPI;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductInfo getProductInfo(UUID uuid) {
        String url = String.format("%s:%s/%s/%s", storageHost, storagePort, storageProductInfoAPI, uuid);
        return restTemplate.getForObject(
                url, ProductInfo.class);
    }
}
