package com.forex.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import com.forex.entity.CurrencyRespository;
import com.forex.entity.ExchangeRate;
import com.forex.entity.ExchangeRateRespository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
@DependsOn("loadApplicationDataService")
public class ConversionRateDataService {

    private static final Logger logger = LoggerFactory.getLogger(ConversionRateDataService.class);

    @Autowired
    private ExchangeRateRespository exchangeRateRespository;

    private Map<String, Double> conversionRate = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        logger.info("Init Method called for ExchangeRateService");
        List<ExchangeRate> exchangeRateList;
        exchangeRateList = exchangeRateRespository.findAll();
        conversionRate = exchangeRateList
                .stream()
                .collect(Collectors
                        .toMap(ex -> ex.getFromCurrency() + ex.getToCurrency(), ex -> ex.getRate())
                );
        logger.info("Exchange rates loaded" + conversionRate.size());
    }

    public Map<String, Double> getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Map<String, Double> conversionRate) {
        this.conversionRate = conversionRate;
    }

}
