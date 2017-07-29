import com.forex.service.ApplicationDataInitService;
import config.AppConfig;
import config.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by ravindras on 7/29/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppConfig.class})
public class CurrencyConversionLoadTest {

    @Autowired
    private ApplicationDataInitService currencyConversionMatrix;

    @Test
    public void testCurrencyMatrixLoad(){

        Map<String, String> currencyMatrixMap =   currencyConversionMatrix.getCurrencyMatrixMap();

        Assert.assertEquals(currencyMatrixMap.size(),5);

    }

}



