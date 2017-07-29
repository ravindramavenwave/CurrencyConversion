import com.forex.service.ApplicationDataInitService;
import config.DataSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ravindras on 7/29/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSource.class})
public class ExchangeRateLoadTest {

@Autowired
private ApplicationDataInitService currencyConversionMatrix;

public void testConversionMatrixLoad(){


}

}

