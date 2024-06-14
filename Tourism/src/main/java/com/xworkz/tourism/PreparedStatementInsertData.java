package com.xworkz.tourism;

import java.sql.*;

public class PreparedStatementInsertData {
    public static void main(String[] args) {
        System.out.println("load and register the driver class");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcUrl ="jdbc:mysql://localhost:3306/Tourism";
        String userName ="root";
        String password = "Xworkzodc@123";

        String query = "Insert into Waterfalls (id,name,river_name,place,state,pincode) values(?,?,?,?,?,?)";

        try {
           Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
