import config.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ravindras on 7/26/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSource.class})
public class CurrencyInitTest {

    @Autowired
    protected ConfigurableApplicationContext context;

    @Test
    public void findAUDCurrency(){

        javax.sql.DataSource globalDataSource = (javax.sql.DataSource) context.getBean("forexDataSource");


    }
}
