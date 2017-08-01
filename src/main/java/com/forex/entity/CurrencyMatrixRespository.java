package com.forex.entity;

import com.forex.entity.CurrencyMatrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyMatrixRespository extends JpaRepository<CurrencyMatrix,Integer> {

    public List<CurrencyMatrix> findAll();
}
