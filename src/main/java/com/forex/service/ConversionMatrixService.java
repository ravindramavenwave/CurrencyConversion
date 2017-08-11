package com.forex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import com.forex.entity.CurrencyMatrix;
import com.forex.entity.CurrencyMatrixRespository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@DependsOn("loadApplicationDataService")
public class ConversionMatrixService {

    private static final Logger logger = LoggerFactory.getLogger(ConversionMatrixService.class);

    @Autowired
    private CurrencyMatrixRespository currencyMatrixRespository;

    private Map<String, String> currencyMatrixMap = null;

    @PostConstruct
    public void init() {
        logger.info("Init Method called for ConversionMatrixService");
        List<CurrencyMatrix> currencyMatrixList = currencyMatrixRespository.findAll();
        currencyMatrixMap = currencyMatrixList
                .stream()
                .collect(Collectors
                        .toMap(e ->
                                        e.getBase() + e.getToCurr()
                                , e -> e.getRelation())
                );

        logger.info(" ConversionMatrixService loaded items"+currencyMatrixMap.size());
    }

    public Map<String, String> getCurrencyMatrixMap() {
        return currencyMatrixMap;
    }

    public void setCurrencyMatrixMap(Map<String, String> currencyMatrixMap) {
        this.currencyMatrixMap = currencyMatrixMap;
    }
}
