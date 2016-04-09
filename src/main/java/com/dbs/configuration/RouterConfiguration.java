package com.dbs.configuration;

import com.dbs.routing.DataSourceKey;
import com.dbs.routing.DatasourceRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Initializes the router.
 */
@Configuration
@Import(DataSourcesConfiguration.class)
public class RouterConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouterConfiguration.class);

    @Autowired
    HashMap<DataSourceKey, DataSource> targetDataSources;

    @Bean
    public DatasourceRouter datasourceRouter() {
        LOGGER.info("Initializing Router...");
        LOGGER.info("No of target datasources: " + targetDataSources.size());

        DatasourceRouter datasourceRouter= new DatasourceRouter();
        datasourceRouter.setTargetDataSources((Map) targetDataSources);

        return datasourceRouter;
    }
}
