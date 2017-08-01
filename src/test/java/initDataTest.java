import com.forex.service.ConversionMatrixService;
import com.forex.service.CurrencyDataService;
import com.forex.service.ConversionRateDataService;
import com.forex.ApplicationStart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ravindras on 7/29/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ApplicationStart.class})
public class initDataTest {

    @Autowired
    ConversionRateDataService conversionRateDataService;

    @Autowired
    CurrencyDataService currencyService;

    @Autowired
    ConversionMatrixService conversionMatrixService;

    @Test
    public void loadExchangeRate(){
        Assert.assertEquals(conversionRateDataService.getConversionRate().size() ,5);
    }

    @Test
    public void loadCurrency(){
        Assert.assertEquals(currencyService.getCurrencyMap().size() ,6);

    }

    @Test
    public void loadCurrencyMatrix(){
        Assert.assertEquals(conversionMatrixService.getCurrencyMatrixMap().size() ,11);
    }
}
