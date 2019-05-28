package com.ms3.csvFileReader.csvFileReader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DSconfig {
    @Autowired
    Environment env;

    @Value("${url}")
    String url;
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(url);
        return dataSource;
    }



//    @Bean
//
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        em.setDataSource(dataSource());
//
//        em.setPackagesToScan(new String[] { "com.baeldung.models" });
//
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//
//    }



    final Properties additionalProperties() {

        final Properties hibernateProperties = new Properties();

        if (env.getProperty("hibernate.hbm2ddl.auto") != null) {

            hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        }

        if (env.getProperty("hibernate.dialect") != null) {

            hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));

        }

        if (env.getProperty("hibernate.show_sql") != null) {

            hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        }

        return hibernateProperties;

    }



}



@Configuration

@Profile("h2")

@PropertySource("classpath:application.properties")

class H2Config {

}

