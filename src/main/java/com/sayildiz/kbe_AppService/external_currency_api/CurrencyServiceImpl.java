package com.sayildiz.kbe_AppService.external_currency_api;

import com.sayildiz.kbe_AppService.file_transfer.Sftp_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private RestTemplate restTemplate;

    private CurrencyExchangeRateUSD todaysRate;
    private final Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    public final String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/eur/usd.json";
    @Override
    public CurrencyExchangeRateUSD getExchangeRateEURtoUSD() {
        return todaysRate;
    }

    @Scheduled(fixedDelay = 24, timeUnit = TimeUnit.HOURS)
    public void getExchangeRateEveryDay() {
        todaysRate = restTemplate.getForObject(url, CurrencyExchangeRateUSD.class);
        logger.info("Todays USDRate =" + todaysRate.getUsd());
    }
}
