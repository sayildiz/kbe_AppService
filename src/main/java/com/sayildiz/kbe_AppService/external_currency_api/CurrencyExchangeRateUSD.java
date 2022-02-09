package com.sayildiz.kbe_AppService.external_currency_api;

import java.math.BigDecimal;

public class  CurrencyExchangeRateUSD {
    private String date;
    private BigDecimal usd;

    public CurrencyExchangeRateUSD(String date, BigDecimal usd) {
        this.date = date;
        this.usd = usd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    @Override
    public String toString() {
        return "CurrencyUSD{" +
                "date='" + date + '\'' +
                ", usd=" + usd +
                '}';
    }
}
