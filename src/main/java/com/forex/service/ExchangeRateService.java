package com.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by ravindras on 7/27/2017.
 */
@Service
public class ExchangeRateService {

    @Autowired
    private ApplicationDataInitService currencyConversionMatrix;


    private Map<String, Double> conversionRateMap ;

    private Map<String, String> currencyMatrixMap;

    private Map<String, Integer> currencyMap;


    public Double getExchangeRate(String from , String to){

        if (from.equals(to)){
            return 1.0;
        }

       currencyMatrixMap = currencyConversionMatrix.currencyMatrixMap;

       conversionRateMap = currencyConversionMatrix.conversionRate;

      return  calculateExchangeRate(from,to);
    }

    private Double calculateExchangeRate(String from, String to) {

        String pair = from+to;
        String mapping = currencyMatrixMap.get(pair);

        if (from.equals(to)){
            return 1.0;
        } else if (mapping.equals("D")){
            return conversionRateMap.get(pair);
        }else if (mapping.equals("INV")) {
            return 1/conversionRateMap.get(pair);
        }else {
            Double rate1 = calculateExchangeRate(from,mapping);
            Double rate2 = calculateExchangeRate(to,mapping);
            return rate1 / rate2;
        }
    }
}
