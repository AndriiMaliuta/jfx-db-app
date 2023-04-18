package com.andmal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbData {
    public DatabaseMetaData metaData(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url, System.getenv("USER"), System.getenv("PASS"));
        return connection.getMetaData();
    }

    public ResultSet schemas(String url) throws SQLException {
        return metaData(url).getSchemas();
    }

    public List<String> comments() throws SQLException {
        Connection connection = DriverManager.getConnection(System.getenv("DB_URL"),
                System.getenv("USER"),
                System.getenv("PASS"));
        PreparedStatement preparedStatement = connection.prepareStatement("select * from comments");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> comments = new ArrayList<>();
        while (resultSet.next()) {
            String comment = resultSet.getString(2);
            comments.add(comment);
        }
        connection.close();
        return comments;
    }

}
