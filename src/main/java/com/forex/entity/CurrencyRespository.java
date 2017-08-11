package com.forex.entity;

import com.forex.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ravindras on 7/26/2017.
 */
public interface CurrencyRespository extends JpaRepository<Currency,Integer> {


}
