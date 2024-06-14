package com.xworkz.crudOperation;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;

public class SelectCollegeStatement {
    public static void main(String[] args) {

        System.out.println("Read and register the Driver class");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Getting connection from Database... ");

        String jdbcUrl ="jdbc:mysql://localhost:3306/College_details";
        String userName ="root";
        String password = "Xworkzodc@123";

        String query = "Select * from College " ;

        Connection connection = null;
        Statement statement = null;
        try {
         connection = DriverManager.getConnection(jdbcUrl,userName,password);
        statement = connection.createStatement();
      ResultSet result =  statement.executeQuery(query);
            System.out.println(result);
            System.out.println("excecuting the query....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Closing costly resourse......");
        try {
            if(statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(connection!=null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
