package com.forex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ForexRateCalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(ForexRateCalculatorService.class);

    @Autowired
    private ConversionRateDataService conversionRateDataService;

    @Autowired
    private ConversionMatrixService conversionMatrixService;

    private Map<String, Double> conversionRateMap;
    private Map<String, String> currencyMatrixMap;

    /**
     * Exposed method that is called to calculate exchange rate.
     *
     * @param from
     * @param to
     * @return
     */
    public Double getExchangeRate(String from, String to) {
        logger.debug(" Extract exchange rate from " + from + " to " + to);
        if (from.equals(to)) {
            return 1.0;
        }

        currencyMatrixMap = conversionMatrixService.getCurrencyMatrixMap();
        conversionRateMap = conversionRateDataService.getConversionRate();
        double exchangeRate = calculateExchangeRate(from, to);
        logger.debug(" Calculated exchange rate from " + from + " to " + to + " rate :" + exchangeRate);
        return exchangeRate;
    }

    /**
     * Recursive method to calculate exchange rate.
     *
     * @param from
     * @param to
     * @return
     * @throws IllegalArgumentException
     */
    private Double calculateExchangeRate(String from, String to) throws IllegalArgumentException {
        logger.info(" Calculate exchange rate from " + from + " to " + to);
        String pair = from + to;
        String mapping = currencyMatrixMap.get(pair);

        if (mapping == null) {
            mapping = tryInvertMapping(to + from);
        }
        if (from.equals(to)) {
            return 1.0;
        } else if (mapping.equals("D")) {
            return conversionRateMap.get(pair);
        } else if (mapping.equals("Inv")) {
            return 1 / conversionRateMap.get(to + from);
        } else {
            Double rate1 = calculateExchangeRate(from, mapping);
            Double rate2 = calculateExchangeRate(to, mapping);
            Double rate = rate1 / rate2;
            logger.debug(" Rate calculated :" + rate);
            return rate;
        }
    }

    /**
     * Get the invert relationship
     *
     * @param pair
     * @return
     */
    private String tryInvertMapping(String pair) {
        String mapping = currencyMatrixMap.get(pair);

        if (mapping == null) {
            logger.debug(" No entry found in currency matrix for pair " + pair);
            throw new IllegalArgumentException("Unable to find entry in Conversion Matrix");
        }

        if (mapping.equals("D"))
            return "Inv";
        else if (mapping.equals("Inv"))
            return "D";
        else
            return mapping;
    }
}
