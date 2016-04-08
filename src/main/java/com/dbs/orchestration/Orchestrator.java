package com.dbs.orchestration;

import com.dbs.DBOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by anghelc on 08/04/16.
 */
@Component
public class Orchestrator {

    @Autowired
    DBOperationService dbOperationService;

    @Autowired
    Connection db1Connection;

    @Autowired
    Connection db2Connection;

    public void runDBOperation() throws SQLException {
        dbOperationService.insertWithPreparedStatement(db1Connection);
    }
}
