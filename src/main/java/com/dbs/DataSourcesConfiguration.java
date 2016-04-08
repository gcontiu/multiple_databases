package com.dbs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by anghelc on 08/04/16.
 */
@Configuration
public class DataSourcesConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourcesConfiguration.class);

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION1 = "jdbc:h2:~/test";
    private static final String DB_USER1 = "";
    private static final String DB_PASSWORD1 = "";
    private static final String DB_CONNECTION2 = "jdbc:h2:~/test";
    private static final String DB_USER2 = "";
    private static final String DB_PASSWORD2 = "";


    @Bean
    public Connection db1Connection() {
        LOGGER.info("Building DB1 connection...");

        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION1, DB_USER1,
                    DB_PASSWORD1);
            dbConnection.setAutoCommit(false);
            LOGGER.info("Created DB1 Connection.");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    @Bean
    public Connection db2Connection() {
        LOGGER.info("Building DB1 connection...");

        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION2, DB_USER2,
                    DB_PASSWORD2);
            dbConnection.setAutoCommit(false);
            LOGGER.info("Created DB1 Connection.");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
