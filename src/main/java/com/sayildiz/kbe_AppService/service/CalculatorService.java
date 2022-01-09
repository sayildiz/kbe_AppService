package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.Price;

import java.math.BigDecimal;

public interface CalculatorService {
    Price getPrice(BigDecimal price);
}
