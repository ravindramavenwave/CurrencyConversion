package com.forex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service("loadApplicationDataService")
@DependsOn("currEntityManagerFactory")
public class LoadSqlDataService {
    private static final Logger logger = LoggerFactory.getLogger(LoadSqlDataService.class);

    @Autowired
    protected ConfigurableApplicationContext context;

    @Value("${init-sql-data}")
    private String initSql;

    @Value("${profile}")
    private String profile;


    @PostConstruct
    public void initDbLoad(){
        logger.debug(" Database init method called for DB load");
        javax.sql.DataSource dataSource = (javax.sql.DataSource) context.getBean("forexDataSource");
        // Populate the database with some data
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        // Create the path to the script
        ClassPathResource sqlScript = new ClassPathResource(profile+"-"+initSql);
        // Load it into the populator
        populator.setScripts(sqlScript);
        // Run the script
        DatabasePopulatorUtils.execute(populator, dataSource);

    }
}
