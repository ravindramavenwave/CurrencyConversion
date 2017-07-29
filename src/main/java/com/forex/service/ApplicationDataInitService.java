package com.forex.service;


import repository.Currency;
import repository.CurrencyMatrix;
import repository.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import repository.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
@DependsOn("loadApplicationDataService")
public class ApplicationDataInitService {

  @Autowired
  private CurrencyMatrixRespository currencyMatrixRespository;

  @Autowired
  private ExchangeRateRespository exchangeRateRespository;

  @Autowired
  private CurrencyRespository currencyRespository;

  Map<String,Double> conversionRate = new ConcurrentHashMap<>();

  Map<String, String> currencyMatrixMap = new ConcurrentHashMap<>();

  Map<String, Integer> currencyMap = new ConcurrentHashMap<>();


  @PostConstruct
  public void init(){

     List<CurrencyMatrix> currencyMatrixList =currencyMatrixRespository.findAll();
     currencyMatrixMap = currencyMatrixList
            .stream()
            .collect(Collectors
                    .toMap(e ->
                            e.getBase()+e.getToCurr()
                            ,e -> e.getRelation())
                     );

      List<ExchangeRate> exchangeRateList;
      exchangeRateList = exchangeRateRespository.findAll();
      conversionRate =exchangeRateList
              .stream()
              .collect(Collectors
                      .toMap(ex -> ex.getFromCurrency()+ex.getToCurrency(),ex -> ex.getRate())
              );

      List<Currency> currencies;
      currencies = currencyRespository.findAll();
      currencyMap =currencies
              .stream()
              .collect(Collectors
                      .toMap(c -> c.getCode(),c -> c.getFormat())
              );


  }

    public Map<String, Double> getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Map<String, Double> conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Map<String, String> getCurrencyMatrixMap() {
        return currencyMatrixMap;
    }

    public void setCurrencyMatrixMap(Map<String, String> currencyMatrixMap) {
        this.currencyMatrixMap = currencyMatrixMap;
    }

    public Map<String, Integer> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(Map<String, Integer> currencyMap) {
        this.currencyMap = currencyMap;
    }
}
