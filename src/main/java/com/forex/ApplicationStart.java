package com.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *  The class will start the server on localhost:8080.
 *  Run the main method of the class to start server.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ApplicationStart {

    /**
     * Main method to start the application.
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication
                .run(ApplicationStart.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
