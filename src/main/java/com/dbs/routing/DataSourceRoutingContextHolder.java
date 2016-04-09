package com.dbs.routing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uses a ThreadLocal to hold the key for the Data Source that is currently used.
 */
public class DataSourceRoutingContextHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceRoutingContextHolder.class);
    private static final ThreadLocal<DataSourceKey> routingContextHolder = new ThreadLocal<>();

    public static void setDataSource(DataSourceKey dataSourceNumber) {
        routingContextHolder.set(dataSourceNumber);
    }

    public static DataSourceKey getDataSource() {
        LOGGER.info("Using " + routingContextHolder.get().name());
        return routingContextHolder.get();
    }



}
