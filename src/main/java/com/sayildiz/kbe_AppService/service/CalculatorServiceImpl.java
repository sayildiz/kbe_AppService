package com.sayildiz.kbe_AppService.service;

import com.sayildiz.kbe_AppService.model.Price;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Price getPrice(BigDecimal price) {
        //TODO Consume Calculator REST API
        return new Price(BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
    }
}
