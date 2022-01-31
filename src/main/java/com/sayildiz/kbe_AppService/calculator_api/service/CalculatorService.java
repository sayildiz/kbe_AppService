package com.sayildiz.kbe_AppService.calculator_api.service;

import com.sayildiz.kbe_AppService.calculator_api.model.Price;

import java.math.BigDecimal;

public interface CalculatorService {
    Price getPrice(BigDecimal price);
}
