package com.forex.controller;

import com.forex.entity.*;
import com.forex.service.CurrencyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller will calculate Exchange Rate for given pair.
 */
@RestController
public class ExchangeDataController {

    @Autowired
    private CurrencyMatrixRespository currencyMatrixRespository;

    @Autowired
    private CurrencyRespository currencyRespository;

    @Autowired
    private ExchangeRateRespository exchangeRateRespository;

    @Autowired
    private CurrencyDataService currencyService;

    @RequestMapping("/currency")
    public List<Currency> getCurrency() {
        return currencyRespository.findAll();
    }

    @RequestMapping("/rates")
    public List<ExchangeRate> getConversionMatrix() {
        return exchangeRateRespository.findAll();
    }

    @RequestMapping("/matrix")
    public List<CurrencyMatrix> getExchangeRate() {
        return currencyMatrixRespository.findAll();
    }

}
