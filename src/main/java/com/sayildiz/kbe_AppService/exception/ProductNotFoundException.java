package com.sayildiz.kbe_AppService.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(UUID uuid){
        super("Could not find song with UUID " + uuid);
    }
}
