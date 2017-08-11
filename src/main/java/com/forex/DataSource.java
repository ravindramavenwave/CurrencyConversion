package com.forex;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@EnableConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "currEntityManagerFactory",
        transactionManagerRef = "currTransactionManager",
        basePackages = {"com.forex.entity"})
@PropertySource("classpath:${profile}-DbConfig.properties")
@Configuration
public class DataSource {

    @Value("${datasource.dialect}")
    private String dialect;

    @Value("${datasource.showsql}")
    private String showSql;

    @Value("${datasource.generateDDL}")
    private String generateDDL;

    @Value("${datasource.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.driverClassName}")
    private String driverClass;

    @Value("${datasource.hibernate.ejb.naming_strategy}")
    private String strategy;

    @Value("${datasource.packagescan}")
    private String packageScan;

    @Value("${database.init.sql}")
    private String initSql;

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public javax.sql.DataSource forexDataSource() {
        return DataSourceBuilder.create().build();

    }

    @Bean
    public PlatformTransactionManager currTransactionManager() {
        return new JpaTransactionManager(currEntityManagerFactory());
    }

    @Bean
    public EntityManagerFactory currEntityManagerFactory() {
        return genericEntityManagerFactory
                (forexDataSource(), initSql);
    }

    @Bean
    public EntityManager entityManager() {
        return currEntityManagerFactory().createEntityManager();
    }

    /**
     * This method will create enitityManager from datasource.
     *
     * @param dataSource
     * @param scriptPath
     * @return
     */
    public EntityManagerFactory genericEntityManagerFactory(javax.sql.DataSource dataSource, String scriptPath) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(new Boolean(showSql));
        vendorAdapter.setGenerateDdl(new Boolean(generateDDL));
        vendorAdapter.setDatabasePlatform(dialect);
        Properties jpaProperties = new Properties();

        if (hbm2ddlAuto.contains("create") && (scriptPath != null)) {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            ClassPathResource schemaScript = new ClassPathResource(scriptPath);
            populator.setScripts(new Resource[]{schemaScript});
            DatabasePopulatorUtils.execute(populator, dataSource);
        }
        //set default
        if (strategy == null) {
            strategy = "org.hibernate.cfg.ImprovedNamingStrategy";
        }
        jpaProperties.put("hibernate.ejb.naming_strategy", strategy);

        String[] packagesToScan = new String[]{packageScan};
        LocalContainerEntityManagerFactoryBean factory = getFactoryBean(vendorAdapter, packagesToScan, dataSource, jpaProperties);
        return factory.getObject();
    }

    private LocalContainerEntityManagerFactoryBean getFactoryBean(HibernateJpaVendorAdapter vendorAdapter, String[] packagesToScan, javax.sql.DataSource dataSource, Properties jpaProperties) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        if (packagesToScan != null)
            factory.setPackagesToScan(packagesToScan);
        factory.setPersistenceUnitName("PersistenceUnit");
        factory.setDataSource(dataSource);
        factory.getJpaDialect();
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
