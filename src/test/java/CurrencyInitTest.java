import com.forex.ApplicationStart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Test will be useful to test DB connectivity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ApplicationStart.class})
public class CurrencyInitTest {

    @Autowired
    protected ConfigurableApplicationContext context;

    @Test
    public void findAUDCurrency() throws SQLException {

        javax.sql.DataSource dataSource = (javax.sql.DataSource) context.getBean("forexDataSource");
        // Populate the database with some data

        Connection conn = dataSource.getConnection();

    }
}
