package com.forex.entity;

import com.forex.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRateRespository extends JpaRepository<ExchangeRate,Integer> {

    public List<ExchangeRate> findAll();
}
