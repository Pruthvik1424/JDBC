package com.xworkz.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCollegeStatement {
    public static void main(String[] args) {
        System.out.println("Load and register the Driver class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Getting connection from database....");

        String jdbcUrl ="jdbc:mysql://localhost:3306/College_details";
        String userName ="root";
        String password ="Xworkzodc@123";

        String Query = "Update College Set College_type ='Aided' where id = 2";

        Connection connection = null;
        Statement statement =null;
        try {
          connection = DriverManager.getConnection(jdbcUrl,userName,password);
        statement = connection.createStatement();
      boolean exce = statement.execute(Query);
            System.out.println(exce);
            System.out.println("excecuted query....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("colsing costly resourse....");

        try {
            if(statement !=null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
