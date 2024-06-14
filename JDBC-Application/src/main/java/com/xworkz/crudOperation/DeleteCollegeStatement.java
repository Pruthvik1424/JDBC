package com.xworkz.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCollegeStatement {
    public static void main(String[] args) {
        System.out.println("load and register the driver");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("getting connection from database");
        String jdbcUrl = "jdbc:mysql://localhost:3306/College_details";
        String userName = "root";
        String password = "Xworkzodc@123";

        String query = "Delete from  college where id = 1";

        Connection connection = null;
        Statement statement = null;
        try {
         connection = DriverManager.getConnection(jdbcUrl,userName,password);
        statement = connection.createStatement();
            System.out.println("executing query.....");
      boolean exce= statement.execute(query);
            System.out.println(exce);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Closing costly resource statement and connection");

        try {
            if(statement != null) {
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
