package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.calculator_api.model.Price;
import com.sayildiz.kbe_AppService.calculator_api.service.CalculatorService;
import com.sayildiz.kbe_AppService.exception.ProductNotFoundException;
import com.sayildiz.kbe_AppService.external_currency_api.CurrencyExchangeRateUSD;
import com.sayildiz.kbe_AppService.external_currency_api.CurrencyService;
import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.model.ProductDTO;
import com.sayildiz.kbe_AppService.model.ProductDetails;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import com.sayildiz.kbe_AppService.storage_api.model.ProductInfo;
import com.sayildiz.kbe_AppService.storage_api.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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

    @Autowired
    CurrencyService currencyService;

    @Override
    public List<ProductDTO> getProductList() {
        List<Product> productList =  repository.findAll();
        CurrencyExchangeRateUSD usdRate = currencyService.getExchangeRateEURtoUSD();
        if(usdRate == null){
            throw new RuntimeException("usdRate is null");
        }
        List<ProductDTO> dtoList = new ArrayList<>();
        for(Product product: productList){
            BigDecimal usdPrice = product.getPrice().multiply(usdRate.getUsd()).setScale(2, RoundingMode.HALF_UP);
            ProductDTO newDTO = new ProductDTO();
            newDTO.setPriceUSD(usdPrice);
            BeanUtils.copyProperties(product, newDTO);
            dtoList.add(newDTO);
        }
        return dtoList;
    }

    @Override
    public ProductDetails getProductByUuid(UUID uuid) {
        ProductDetails productDetails = new ProductDetails();

        Product product = repository.findByUuid(uuid);
        if(product == null){
            throw new ProductNotFoundException(uuid);
        }
        ProductInfo productInfo = storageService.getProductInfo(uuid);
        Price price = calculatorService.getPrice(product.getPrice());

        BeanUtils.copyProperties(price, productDetails);
        BeanUtils.copyProperties(productInfo, productDetails);
        BeanUtils.copyProperties(product, productDetails);
        return productDetails;
    }

}