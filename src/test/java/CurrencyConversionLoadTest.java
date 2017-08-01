import com.forex.service.ConversionMatrixService;
import com.forex.ApplicationStart;
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
@SpringApplicationConfiguration(classes = {ApplicationStart.class})
public class CurrencyConversionLoadTest {

    @Autowired
    private ConversionMatrixService conversionMatrixService;

    @Test
    public void testCurrencyMatrixLoad(){

        Map<String, String> currencyMatrixMap =   conversionMatrixService.getCurrencyMatrixMap();

        Assert.assertEquals(currencyMatrixMap.size(),11);

    }

}



