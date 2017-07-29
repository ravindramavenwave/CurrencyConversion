package repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Currency implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private String code;

    @Column
    private String country;

    @Column
    private Integer format;

    public Currency(){}

    public Currency(String code, String country) {
        this.code = code;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (code != null ? !code.equals(currency.code) : currency.code != null) return false;
        if (country != null ? !country.equals(currency.country) : currency.country != null) return false;
        return format != null ? format.equals(currency.format) : currency.format == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
}
