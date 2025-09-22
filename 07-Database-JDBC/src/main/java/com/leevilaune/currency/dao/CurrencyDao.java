package com.leevilaune.currency.dao;

import java.sql.*;
import java.util.*;

import java.sql.ResultSet;
import java.util.List;

import com.leevilaune.currency.datasource.MariaDBConnection;

public class CurrencyDao {


    public List<String> getAllCurrencyCodes() {
        String sql = "SELECT code FROM currency";
        List<String> currencies = new ArrayList<>();

        try {
            Connection conn = MariaDBConnection.getConnection();
            if (conn == null) {
                System.err.println("Database connection failed");
                return Collections.emptyList();
            }
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                currencies.add(rs.getString("code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return currencies;

        }
        return currencies;
    }

    public double getUSDRate(String code) {
        String sql = "SELECT rate_to_usd FROM currency WHERE code=?";

        try {
            Connection conn = MariaDBConnection.getConnection();
            if(conn == null){
                return -1;
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
