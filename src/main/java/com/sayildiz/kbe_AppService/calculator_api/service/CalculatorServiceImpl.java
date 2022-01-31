package com.sayildiz.kbe_AppService.calculator_api.service;

import com.sayildiz.kbe_AppService.calculator_api.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Value("${calculator.host}")
    private String calculatorHost;

    @Value("${calculator.port}")
    private String calculatorPort;

    @Value("${calculator.VatAPI}")
    private String calculatorVatAPI;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Price getPrice(BigDecimal price) {
        String url = String.format("%s:%s/%s", calculatorHost, calculatorPort, calculatorVatAPI);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(price.toPlainString(), headers);

        return restTemplate.postForObject(
                url, request, Price.class);
    }
}
