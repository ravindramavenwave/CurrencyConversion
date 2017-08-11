package com.forex.controller;

import java.io.Serializable;


public class ExchangeRateResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fromCurrency;

    private String toCurrency;

    private String value;

    public ExchangeRateResponse() {
    }

    public ExchangeRateResponse(String fromCurrency, String toCurrency, String value) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", value=" + value +
                '}';
    }
}
