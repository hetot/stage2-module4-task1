package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        try (InputStream input = H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String driver = properties.getProperty("jdbc_driver");
            String url = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
