package com.forex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import com.forex.entity.Currency;
import com.forex.entity.CurrencyRespository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
@DependsOn("loadApplicationDataService")
public class CurrencyDataService {

   private Map<String, Integer> currencyMap = new ConcurrentHashMap<>();

   @Autowired
   private CurrencyRespository currencyRespository;

    @PostConstruct
    public void init() {
        List<Currency> currencies;
        currencies = currencyRespository.findAll();
        currencyMap =currencies
                .stream()
                .collect(Collectors
                        .toMap(c -> c.getCode(),c -> c.getFormat())
                );
    }


    public Map<String, Integer> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(Map<String, Integer> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public boolean isValidCurrency(String country){
        return currencyMap.containsKey(country);
    }

    public Integer getFormat(String country){
      Integer  precision = currencyMap.get(country);
      return precision;
    }
}