package com.xworkz.tourism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDeleteData {
    public static void main(String[] args) {
        System.out.println("load and register the driver class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcUrl ="jdbc:mysql://localhost:3306/Tourism";
        String userName ="root";
        String password ="Xworkzodc@123";

        String query = "Delete from Waterfalls where id = 2";

        Connection connection = null ;
        Statement statement = null;
        try {
          connection = DriverManager.getConnection(jdbcUrl,userName,password);
          statement =connection.createStatement();
        int result = statement.executeUpdate(query);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
