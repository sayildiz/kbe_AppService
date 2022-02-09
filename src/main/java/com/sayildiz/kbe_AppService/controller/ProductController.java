package com.sayildiz.kbe_AppService.controller;

import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.model.ProductDTO;
import com.sayildiz.kbe_AppService.model.ProductDetails;
import com.sayildiz.kbe_AppService.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductDTO> getProductList(){
        logger.info("GET /product");
        return productService.getProductList();
    }

    @GetMapping("/product/{uuid}")
    public ProductDetails getProductDetailsByUUID(@PathVariable UUID uuid){
        return productService.getProductByUuid(uuid);
    }
}
