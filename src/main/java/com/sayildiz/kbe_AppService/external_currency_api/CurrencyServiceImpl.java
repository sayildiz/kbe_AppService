package com.sayildiz.kbe_AppService.external_currency_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Autowired
    private RestTemplate restTemplate;

    public final String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/eur/usd.json";
    @Override
    public CurrencyExchangeRateUSD getExchangeRateEURtoUSD() {
        return restTemplate.getForObject(
                url, CurrencyExchangeRateUSD.class);
    }
}
