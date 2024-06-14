package com.xworkz.tourism;

import java.sql.*;

public class StatementFetchData {
    public static void main(String[] args) {

        System.out.println("load and register driver class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/Tourism";
        String userName = "root";
        String password = "Xworkzodc@123";

        String query = "select * from Waterfalls where id = 1";

        Connection connection = null;
        Statement statement = null;

        try {
          connection= DriverManager.getConnection(jdbcUrl,userName,password);
        statement = connection.createStatement();
      ResultSet result = statement.executeQuery(query);
            System.out.println(result);

            while (result.next()){
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("river_name"));
                System.out.println(result.getString("place"));
                System.out.println(result.getString("state"));
                System.out.println(result.getInt("pincode"));
            }



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
            if(connection!= null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
