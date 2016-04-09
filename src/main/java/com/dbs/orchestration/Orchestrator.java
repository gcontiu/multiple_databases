package com.dbs.orchestration;

import com.dbs.service.DBOperationService;
import com.dbs.routing.DataSourceKey;
import com.dbs.routing.DatasourceRouter;
import com.dbs.routing.DataSourceRoutingContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by anghelc on 08/04/16.
 */
@Component
public class Orchestrator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Orchestrator.class);
    @Autowired
    DBOperationService dbOperationService;

    @Autowired
    DatasourceRouter datasourceRouter;

    public void runDBOperation() throws SQLException {

        LOGGER.info("###################### START OPERATIONS ###########################");

        DataSourceRoutingContextHolder.setDataSource(DataSourceKey.FTE2);
        dbOperationService.insertWithPreparedStatement(datasourceRouter.getConnection());

        LOGGER.info("###################### END OPERATIONS ###########################");
    }
}
