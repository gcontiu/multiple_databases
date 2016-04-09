package com.dbs.configuration;

import com.dbs.routing.DataSourceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by anghelc on 08/04/16.
 */
@Configuration
public class DataSourcesConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourcesConfiguration.class);


    @Value("${db.driver}")
    private String driver;

    @Value("${db.fte1.connection}")
    private String dbFte1Connection;
    @Value("${db.fte1.username}")
    private String dbFte1Username;
    @Value("${db.fte1.password}")
    private String dbFte1Password;


    @Value("${db.fte2.connection}")
    private String dbFte2Connection;
    @Value("${db.fte2.username}")
    private String dbFte2Username;
    @Value("${db.fte2.password}")
    private String dbFte2Password;


    @Value("${db.fte3.connection}")
    private String dbFte3Connection;
    @Value("${db.fte3.username}")
    private String dbFte3Username;
    @Value("${db.fte3.password}")
    private String dbFte3Password;


    /**
     * This bean will be referenced by the datasource router bean. It will contain all the datasources that the router will use.
     */
    @Bean
    public HashMap<DataSourceKey, DataSource> targetDataSources() {
        HashMap<DataSourceKey, DataSource> dataSources = new HashMap<>();


        DriverManagerDataSource fte1DriverManagerDataSource = getDriverManagerDataSource(driver, dbFte1Connection, dbFte1Username, dbFte1Password);
        dataSources.put(DataSourceKey.FTE1, fte1DriverManagerDataSource);

        DriverManagerDataSource fte2DriverManagerDataSource = getDriverManagerDataSource(driver, dbFte2Connection, dbFte2Username, dbFte2Password);
        dataSources.put(DataSourceKey.FTE2, fte2DriverManagerDataSource);

        DriverManagerDataSource fte3DriverManagerDataSource = getDriverManagerDataSource(driver, dbFte3Connection, dbFte3Username, dbFte3Password);
        dataSources.put(DataSourceKey.FTE3, fte3DriverManagerDataSource);

        return dataSources;

    }

    /**
     * Used for creating a data source based on the provided parameters.
     */
    private DriverManagerDataSource getDriverManagerDataSource(String localDriver, String localConnection, String localUserName, String localPassword) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(localConnection);
        driverManagerDataSource.setDriverClassName(localDriver);
        driverManagerDataSource.setUsername(localUserName);
        driverManagerDataSource.setPassword(localPassword);
        return driverManagerDataSource;
    }

}
