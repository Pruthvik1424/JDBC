package com.xworkz.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCollegeStatement {
    public static void main(String[] args) {

        System.out.println(" Load and rigester the Driver");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/College_details";
        String userName = "root";
        String password ="Xworkzodc@123";

        System.out.println("Getting connection from database...");
        String Query = "Insert into college(id,College_name,College_type,Location) values(1,'PES college','prvt','Mandya')";
        String Query1 = "Insert into college(id,College_name,College_type,Location) values(2,'BMS college','prvt','Bengaluru')";
        String Query2 = "Insert into college(id,College_name,College_type,Location) values(3,'JSS college','prvt','Bengaluru')";
        String Query3 = "Insert into college(id,College_name,College_type,Location) values(4,'GOVT college','govt','Bengaluru')";
        String Query4 = "Insert into college(id,College_name,College_type,Location) values(5,'GOVT ENG college','govt','Bengaluru')";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl,userName,password);
          statement = connection.createStatement();
        boolean exce = statement.execute(Query);
        boolean exce1 = statement.execute(Query1);
        boolean exce2 = statement.execute(Query2);
        boolean exce3 = statement.execute(Query3);
        boolean exce4 = statement.execute(Query4);

        System.out.println("executing the query.....");

        System.out.println(exce);
        System.out.println(exce1);
        System.out.println(exce2);
        System.out.println(exce3);
        System.out.println(exce4);
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
        System.out.println("closeing costly resource (statement and connection)");


    }
}
