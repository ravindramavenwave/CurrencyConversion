import java.io.Serializable;

/**
 * Created by ravindras on 7/28/2017.
 */
public class getExchangeRateResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
