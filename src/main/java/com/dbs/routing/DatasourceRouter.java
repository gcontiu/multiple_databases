package com.dbs.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * This is the place where the routing implementation starts.
 */
public class DatasourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceRoutingContextHolder.getDataSource();
    }
}
