import com.forex.service.ApplicationDataInitService;
import config.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Test will be useful to test DB connectivity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSource.class})
public class CurrencyInitTest {

    @Autowired
    protected ConfigurableApplicationContext context;

 //   @Autowired
  //  private ApplicationDataInitService currencyConversionMatrix;


    @Test
    public void findAUDCurrency(){

        javax.sql.DataSource dataSource = (javax.sql.DataSource) context.getBean("forexDataSource");
        // Populate the database with some data
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        // Create the path to the script
        ClassPathResource sqlScript = new ClassPathResource("test-init.sql");
        // Load it into the populator
        populator.setScripts(sqlScript);
        // Run the script
        DatabasePopulatorUtils.execute(populator, dataSource);

      //  currencyConversionMatrix.getConversionRate();
    }
}
