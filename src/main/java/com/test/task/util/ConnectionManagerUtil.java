package com.test.task.util;

import com.test.task.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerUtil {

    private static final String URL_KEY="db.url";
    private static final String LOGIN_KEY="db.username";
    private static final String PASSWORD_KEY="db.password";

    static {
        loadDriver();
    }

    public static Connection openConnection(){

        try {
            return  DriverManager.getConnection(
                    PropertiesUtil.getProperties(URL_KEY),
                    PropertiesUtil.getProperties(LOGIN_KEY),
                    PropertiesUtil.getProperties(PASSWORD_KEY));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void loadDriver(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
