package com.forex.controller;

import com.forex.service.CurrencyDataService;
import com.forex.service.ForexRateCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will calculate Exchange Rate for given pair.
 *
 */
@RestController
public class ExchangeRateController {

    @Autowired
    private ForexRateCalculatorService currencyConversionService;

    @Autowired
    private CurrencyDataService currencyService;

    @RequestMapping("/calculator")
    public ExchangeRateResponse convert(@RequestParam(value = "from") String fromCurrency
            , @RequestParam(value = "to") String toCurrency
            , @RequestParam(value = "value") Double value) {

        Boolean isValid = validateInput(fromCurrency, toCurrency, value);

        if (!isValid)
            return new ExchangeRateResponse(fromCurrency, toCurrency, null);

        Double conversionRate = null;
        conversionRate = currencyConversionService.getExchangeRate(fromCurrency, toCurrency);
        Integer precision = currencyService.getFormat(toCurrency);
        Double newAmount = convertValue(conversionRate, value);

        return new ExchangeRateResponse(fromCurrency, toCurrency, formatValue(newAmount,precision));
    }

    private String formatValue(Double newAmount,Integer decimal) {
        return String.format( "%."+decimal.intValue()+"f", newAmount );
    }

    private Boolean validateInput(String fromCurrency, String toCurrency, Double value) {
        return currencyService.isValidCurrency(fromCurrency)
                && currencyService.isValidCurrency(toCurrency) && validateAmount(value);
    }

    private boolean validateAmount(Double value) {
        return value == null ? false : value >= 0.0;
    }

    private double convertValue(Double conversionRate, Double amount) {
        return amount.doubleValue() * conversionRate.doubleValue();
    }

}
