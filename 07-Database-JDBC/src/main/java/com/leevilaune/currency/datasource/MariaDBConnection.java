package com.leevilaune.currency.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {

    private static Connection conn = null;
    private static final String URL = "jdbc:mariadb://localhost:3307/currencydb";
    private static final String USER = "appuser";
    private static final String PASSWORD = "StrongPasswordHere";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void terminate() {
        try {
            System.out.println("Terminating Connection");
            if(getConnection() != null){
                getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
