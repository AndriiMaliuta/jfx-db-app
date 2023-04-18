package com.andmal;

import java.sql.*;

public class DbData {
    public DatabaseMetaData metaData(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url, System.getenv("USER"), System.getenv("PASS"));
        return connection.getMetaData();
    }

    public ResultSet schemas(String url) throws SQLException {
        return metaData(url).getSchemas();
    }
}
