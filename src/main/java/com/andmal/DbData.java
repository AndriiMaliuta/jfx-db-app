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

    public List<Comment> comments(int count) throws SQLException {
        Connection connection = DriverManager.getConnection(System.getenv("DB_URL"),
                System.getenv("USER"),
                System.getenv("PASS"));
        ArrayList<Comment> comments = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select id, body, created_at from comments");
        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;
        while (resultSet.next()) {
            if (counter < count) {
                System.out.println(resultSet.getArray(0));
                long id = resultSet.getLong(0);
                String body = resultSet.getString(1);
                String date = resultSet.getString(2);
                Comment comment = new Comment(id, date, body);
                comments.add(comment);
                counter++;
            } else {
                break;
            }
        }
        connection.close();
        return comments;
    }

}
