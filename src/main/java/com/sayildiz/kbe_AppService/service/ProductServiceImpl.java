package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.Price;
import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.model.ProductDetails;
import com.sayildiz.kbe_AppService.model.ProductInfo;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private CalculatorService calculatorService;

    @Override
    public List<Product> getProductList() {
        return repository.findAll();
    }

    @Override
    public ProductDetails getProductByUuid(UUID uuid) {
        //TODO Validate ProductDetails Result
        ProductDetails productDetails = new ProductDetails();

        Product product = repository.findByUuid(uuid);
        ProductInfo productInfo = storageService.getProductInfo(uuid);
        Price price = calculatorService.getPrice(product.getPrice());

        BeanUtils.copyProperties(price, productDetails);
        BeanUtils.copyProperties(productInfo, productDetails);
        BeanUtils.copyProperties(product, productDetails);
        return productDetails;
    }

}