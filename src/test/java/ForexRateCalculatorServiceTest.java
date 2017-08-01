import com.forex.service.ForexRateCalculatorService;
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
public class ForexRateCalculatorServiceTest {

@Autowired
private ForexRateCalculatorService currencyConversionService;

@Test
public void calculateExchangeRate(){
    Double audusd =  currencyConversionService.getExchangeRate("AUD" ,"USD");
    Double jpnusd =  currencyConversionService.getExchangeRate("JPN" ,"USD");
    Double cadusd =  currencyConversionService.getExchangeRate("CAD" ,"USD");
    Double audjpn =  currencyConversionService.getExchangeRate("AUD" ,"JPN");
    Double audchk =  currencyConversionService.getExchangeRate("AUD" ,"CHK");

    Assert.assertTrue(audchk.toString().equals(""+ 0.13333333333333333));
    Assert.assertTrue(audusd.toString().equals(""+ 4.0));
    Assert.assertTrue(jpnusd.toString().equals(""+ 400.0));
    Assert.assertTrue(cadusd.toString().equals(""+ 2.0));
    Assert.assertTrue(audjpn.toString().equals(""+ 0.01));
}

}

