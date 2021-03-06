package com.forex.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CurrencyMatrix  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Long            id;

    @Column
    private String base;

    @Column
    private String toCurrency;

    @Column
    private String relation;

    public CurrencyMatrix(){}

    public CurrencyMatrix(String base, String toCurr, String relation) {
        this.base = base;
        this.toCurrency = toCurr;
        this.relation = relation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getToCurr() {
        return toCurrency;
    }

    public void setToCurr(String toCurr) {
        this.toCurrency = toCurr;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyMatrix that = (CurrencyMatrix) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (base != null ? !base.equals(that.base) : that.base != null) return false;
        if (toCurrency != null ? !toCurrency.equals(that.toCurrency) : that.toCurrency != null) return false;
        return relation != null ? relation.equals(that.relation) : that.relation == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (toCurrency != null ? toCurrency.hashCode() : 0);
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        return result;
    }
}
