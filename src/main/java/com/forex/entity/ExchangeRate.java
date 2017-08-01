package com.forex.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ExchangeRate implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Double ratio;

    @Column(nullable = false)
    private String fromCurrency;

    @Column(nullable = false)
    private String toCurrency;

    @Column(nullable = false)
    private Integer date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRate() {
        return ratio;
    }

    public void setRate(Double rate) {
        this.ratio = rate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public ExchangeRate(){}

    public ExchangeRate(Double ratio, String fromCurrency, String toCurrency, Integer date) {
        this.ratio = ratio;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeRate that = (ExchangeRate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ratio != null ? !ratio.equals(that.ratio) : that.ratio != null) return false;
        if (fromCurrency != null ? !fromCurrency.equals(that.fromCurrency) : that.fromCurrency != null) return false;
        if (toCurrency != null ? !toCurrency.equals(that.toCurrency) : that.toCurrency != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (fromCurrency != null ? fromCurrency.hashCode() : 0);
        result = 31 * result + (toCurrency != null ? toCurrency.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
